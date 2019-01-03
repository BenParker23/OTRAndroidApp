package com.otr.soap;

// ----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.2.8.1
//
// Created by Quasar Development
//
// ---------------------------------------------------

import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class RunProcessResponse extends AttributeContainer implements KvmSerializable
{

	public String				Error;

	public String				Summary;

	public String				LogInfo;

	public String				Data;

	public ADLoginResponse		ADLoginResponse;

	public Boolean				IsError		= false;

	public Boolean				IsReport	= false;

	public String				ReportFormat;
	private transient Object	__source;

	public void loadFromSoap(Object paramObj, ExtendedSoapSerializationEnvelope __envelope)
	{
		if (paramObj == null)
			return;
		AttributeContainer inObj = (AttributeContainer) paramObj;
		__source = inObj;
		if (inObj instanceof SoapObject)
		{
			SoapObject soapObject = (SoapObject) inObj;
			int size = soapObject.getPropertyCount();
			for (int i0 = 0; i0 < size; i0++)
			{
				PropertyInfo info = soapObject.getPropertyInfo(i0);
				if (!loadProperty(info, soapObject, __envelope))
				{
				}
			}
		}
		if (inObj.hasAttribute("IsError"))
		{
			Object j = inObj.getAttribute("IsError");
			if (j != null)
			{
				IsError = new Boolean(j.toString());
			}
		}
		if (inObj.hasAttribute("IsReport"))
		{
			Object j = inObj.getAttribute("IsReport");
			if (j != null)
			{
				IsReport = new Boolean(j.toString());
			}
		}
		if (inObj.hasAttribute("ReportFormat"))
		{
			Object j = inObj.getAttribute("ReportFormat");
			if (j != null)
			{
				ReportFormat = j.toString();
			}
		}

	}

	protected boolean loadProperty(PropertyInfo info, SoapObject soapObject,
			ExtendedSoapSerializationEnvelope __envelope)
	{
		Object obj = info.getValue();
		if (info.name.equals("Error"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.Error = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.Error = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("Summary"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.Summary = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.Summary = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("LogInfo"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.LogInfo = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.LogInfo = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("Data"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.Data = j.toString();
					}
				}
				else
				{
					this.Data = obj.toString();
				}
			}
			return true;
		}
		if (info.name.equals("ADLoginResponse"))
		{
			if (obj != null)
			{
				Object j = obj;
				this.ADLoginResponse = (ADLoginResponse) __envelope.get(j, ADLoginResponse.class, false);
			}
			return true;
		}
		return false;
	}

	public Object getOriginalXmlSource()
	{
		return __source;
	}

	@Override
	public Object getProperty(int propertyIndex)
	{
		// !!!!! If you have a compilation error here then you are using old
		// version of ksoap2 library. Please upgrade to the latest version.
		// !!!!! You can find a correct version in Lib folder from generated zip
		// file!!!!!
		if (propertyIndex == 0)
		{
			return Error;
		}
		if (propertyIndex == 1)
		{
			return Summary;
		}
		if (propertyIndex == 2)
		{
			return LogInfo;
		}
		if (propertyIndex == 3)
		{
			return Data;
		}
		if (propertyIndex == 4)
		{
			return this.ADLoginResponse != null ? this.ADLoginResponse : SoapPrimitive.NullSkip;
		}
		return null;
	}

	@Override
	public int getPropertyCount()
	{
		return 5;
	}

	@Override
	public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
	{
		if (propertyIndex == 0)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Error";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 1)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Summary";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 2)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "LogInfo";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 3)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Data";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 4)
		{
			info.type = ADLoginResponse.class;
			info.name = "ADLoginResponse";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1)
	{
	}

	@Override
	public int getAttributeCount()
	{
		return 3;
	}

	@Override
	public void getAttributeInfo(int index, AttributeInfo info)
	{
		if (index == 0)
		{
			info.name = "IsError";
			info.namespace = "";
			if (this.IsError != null)
			{
				info.setValue(this.IsError);
			}

		}
		if (index == 1)
		{
			info.name = "IsReport";
			info.namespace = "";
			if (this.IsReport != null)
			{
				info.setValue(this.IsReport);
			}

		}
		if (index == 2)
		{
			info.name = "ReportFormat";
			info.namespace = "";
			if (this.ReportFormat != null)
			{
				info.setValue(this.ReportFormat);
			}

		}
	}

	@Override
	public void getAttribute(int i, AttributeInfo attributeInfo)
	{

	}

	@Override
	public void setAttribute(AttributeInfo attributeInfo)
	{

	}
}
