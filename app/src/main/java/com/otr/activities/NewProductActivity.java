package com.otr.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.otr.R;
import com.otr.soap.DataRow;
import com.otr.soap.IServiceEvents;
import com.otr.soap.ModelADServiceSoapBinding;
import com.otr.soap.ModelRunProcessRequest;
import com.otr.soap.OperationResult;
import com.otr.soap.RunProcessResponse;
import com.otr.webservice.SharedPreferenceUtil;
import com.otr.webservice.WebServiceUtil;

public class NewProductActivity extends Activity {

    private String barcode = "";
    private int m_Product_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
    }


    protected void verifyProductBarcode(String barcode){
        final ModelRunProcessRequest request = new ModelRunProcessRequest();
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferenceUtil.LOGIN_PREF_NAME, MODE_PRIVATE);
        SharedPreferences prefs = sharedPreferences;
        DataRow row = new DataRow();
        row.add(WebServiceUtil.getDataField("Barcode", barcode));
        request.ModelRunProcess = WebServiceUtil.getRunProcessRequest("VerifyProductBarcode", 0, row);
        request.ADLoginRequest = WebServiceUtil.getADLoginRequestToken(sharedPreferences);

        ModelADServiceSoapBinding binding = new ModelADServiceSoapBinding(new IServiceEvents() {
            @Override
            public void Starting()
            {
            }

            @Override
            public void Completed(OperationResult result) {
                RunProcessResponse response = (RunProcessResponse) result.Result;
                if (response != null && response.Error != null && response.Error.length() > 0) {
                    Toast.makeText(getApplicationContext(), "Error: " + response.Error, Toast.LENGTH_LONG).show();

                }
                else if (response != null) {
                    try {
                        String responseStr = new String(Base64.decode(response.Summary.getBytes(), Base64.DEFAULT));
                        Log.d("Response", "Resp : " + responseStr);
                        /** Convert String to List **/
                        /** Check if list size > 0 **/
                        /** If list size == 1 THEN show matched product on screen **/
                        /** If list size == 0 THEN tell user no matched products **/
                        /** If list size > 1 THEN show multiple products on screen and ask user to check **/
                    }
                    catch (Exception e) {
                        Log.d("Exception", e.getLocalizedMessage());
                    }
                }
            }
        }, WebServiceUtil.getAppURL(sharedPreferences));
        try
        {
            binding.runProcessAsync(request);
        }
        catch (Exception e)
        {
            Log.d("Error", e.getMessage());
        }

    }


    protected void addNewProduct(int m_Product_ID){
        final ModelRunProcessRequest request = new ModelRunProcessRequest();
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferenceUtil.LOGIN_PREF_NAME, MODE_PRIVATE);
        SharedPreferences prefs = sharedPreferences;
        DataRow row = new DataRow();
        row.add(WebServiceUtil.getDataField("M_Product_ID", String.valueOf(m_Product_ID)));
        row.add(WebServiceUtil.getDataField("AD_User_ID", prefs.getString(SharedPreferenceUtil.PREF_AD_USER_ID, "")));
        request.ModelRunProcess = WebServiceUtil.getRunProcessRequest("AddNewVerifiedProduct", 0, row);
        request.ADLoginRequest = WebServiceUtil.getADLoginRequestToken(sharedPreferences);

        ModelADServiceSoapBinding binding = new ModelADServiceSoapBinding(new IServiceEvents() {
            @Override
            public void Starting()
            {
            }

            @Override
            public void Completed(OperationResult result) {
                RunProcessResponse response = (RunProcessResponse) result.Result;
                if (response != null && response.Error != null && response.Error.length() > 0) {
                    Toast.makeText(getApplicationContext(), "Error: " + response.Error, Toast.LENGTH_LONG).show();

                }
                else if (response != null) {
                    try {
                        String responseStr = new String(Base64.decode(response.Summary.getBytes(), Base64.DEFAULT));
                    } catch (Exception e) {
                        Log.d("Exception", e.getLocalizedMessage());
                    }
                }
            }
        }, WebServiceUtil.getAppURL(sharedPreferences));
        try
        {
            binding.runProcessAsync(request);
        }
        catch (Exception e)
        {
            Log.d("Error", e.getMessage());
        }
    }

}
