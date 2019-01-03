package com.otr.webservice;

import android.content.SharedPreferences;
import android.util.Base64;

import com.google.gson.Gson;
import com.otr.soap.ADLoginRequest;
import com.otr.soap.DataField;
import com.otr.soap.DataRow;
import com.otr.soap.Enums;
import com.otr.soap.ModelCRUD;
import com.otr.soap.ModelCRUDRequest;
import com.otr.soap.ModelRunProcess;
import com.otr.soap.RunProcessResponse;

import java.util.ArrayList;
import java.util.List;

public class WebServiceUtil
{

	public static final String url = "http://10.0.2.2:8080/ADInterface/services/ModelADService";

	public static ADLoginRequest getADLoginRequest(String userName, String password)
	{
		ADLoginRequest loginRequest = new ADLoginRequest();
		loginRequest.user = userName;
		loginRequest.pass = password;
		loginRequest.ClientID = 1000000;
		loginRequest.RoleID = 1000002;
		loginRequest.OrgID = 1000000;
		loginRequest.WarehouseID = 1000000;
		loginRequest.stage = 9;
		return loginRequest;
	}

	public static ADLoginRequest getADLoginRequestToken(SharedPreferences prefs)
	{
		String userName = prefs.getString(SharedPreferenceUtil.PREF_LOGIN_USER, "");
		String authTokenString = prefs.getString(SharedPreferenceUtil.PREF_LOGIN_TOKEN, "");
		ADLoginRequest loginRequest = new ADLoginRequest();
		loginRequest.user = userName;
		loginRequest.Token = authTokenString;
		return loginRequest;
	}

	public static String getAppURL(SharedPreferences prefs)
	{
		String url = prefs.getString(SharedPreferenceUtil.PREF_SERVER_URL, "");
		return url;
	}

	public static DataField getDataField(String column, String value)
	{
		DataField field = new DataField();
		field.column = column;
		field.val = value;
		return field;
	}

	public static ModelCRUDRequest getModelCrudRequest(String serviceType, String tableName, int recordID,
													   String filter, Enums.ModelCRUD_Action action)
	{
		ModelCRUDRequest request = new ModelCRUDRequest();
		ModelCRUD crud = new ModelCRUD();
		crud.serviceType = serviceType;
		crud.TableName = tableName;
		if (recordID > 0)
		{
			crud.RecordID = recordID;
		}

		if (action != null)
		{
			crud.Action = action;
		}

		if (filter != null && filter.length() > 0)
		{
			crud.Filter = filter;
		}
		request.ModelCRUD = crud;
		return request;
	}

	public static ModelRunProcess getRunProcessRequest(String serviceType, int Record_ID, DataRow params)
	{
		ModelRunProcess request = new ModelRunProcess();
		request.AD_Record_ID = Record_ID;
		request.serviceType = serviceType;
		request.ParamValues = params;
		return request;
	}

	public static <T extends Object> List<T> getResponseEntityList(RunProcessResponse response, Class<T[]> arrayClazz)
	{
		List<T> resultList = new ArrayList<T>();
		if (response.Error == null && response.Summary != null)
		{
			String jsonString = new String(Base64.decode(response.Summary.getBytes(), Base64.DEFAULT));
			T[] array = ((T[]) new Gson().fromJson(jsonString, arrayClazz));
			for (T t : array)
			{
				resultList.add(t);
			}
		}
		return resultList;
	}
}
