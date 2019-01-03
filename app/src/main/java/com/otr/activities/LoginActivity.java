package com.otr.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.otr.R;
import com.otr.soap.ADLoginResponse;
import com.otr.soap.DataField;
import com.otr.soap.DataRow;
import com.otr.soap.DataSet;
import com.otr.soap.Enums;
import com.otr.soap.IServiceEvents;
import com.otr.soap.ModelADServiceSoapBinding;
import com.otr.soap.ModelCRUDRequest;
import com.otr.soap.OperationResult;
import com.otr.soap.WindowTabData;
import com.otr.webservice.SharedPreferenceUtil;
import com.otr.webservice.WebServiceUtil;

public class LoginActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        doLogin("OTRAdmin", "croc5588");
    }


    private void doLogin(final String userName, String password)
    {

        ModelCRUDRequest request = WebServiceUtil.getModelCrudRequest("AppLogin", "AD_User", 0,
                " AD_User_ID = @#AD_User_ID@", Enums.ModelCRUD_Action.Read);
        request.ADLoginRequest = WebServiceUtil.getADLoginRequest(userName, password);

        ModelADServiceSoapBinding binding = new ModelADServiceSoapBinding(new IServiceEvents() {

            @Override
            public void Starting()
            {
            }

            @Override
            public void Completed(OperationResult result)
            {
                WindowTabData response = (WindowTabData) result.Result;

                if (response != null && response.Error != null && response.Error.length() > 0)
                {
                    Toast.makeText(getApplicationContext(), "Error from server: " + response.Error, Toast.LENGTH_SHORT)
                            .show();
                }
                else
                {
                    try
                    {
                        if (response.NumRows > 0)
                        {
                            String AD_User_ID = "";
                            DataSet dataSet = response.DataSet;
                            DataRow row = dataSet.firstElement();
                            DataField field = row.firstElement();
                            if ("AD_User_ID".equals(field.column))
                            {
                                AD_User_ID = field.val;
                            }

                            ADLoginResponse loginResponse = response.ADLoginResponse;
                            String authToken = loginResponse.Token;
                            SharedPreferences preferences = getSharedPreferences(SharedPreferenceUtil.LOGIN_PREF_NAME,
                                    MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(SharedPreferenceUtil.PREF_LOGIN_USER, userName);
                            editor.putString(SharedPreferenceUtil.PREF_LOGIN_TOKEN, authToken);
                            editor.putString(SharedPreferenceUtil.PREF_SERVER_URL, WebServiceUtil.url);
                            editor.putString(SharedPreferenceUtil.PREF_AD_USER_ID, AD_User_ID);
                            editor.commit();

                            Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                            LoginActivity.this.startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Something went wrong, Login failed.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, WebServiceUtil.url);

        try
        {
            binding.queryDataAsync(request);
        }
        catch (Exception e)
        {
            Log.d("Exception",e.getLocalizedMessage());
        }
    }



}
