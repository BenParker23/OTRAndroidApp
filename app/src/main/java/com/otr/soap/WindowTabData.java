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

public class WindowTabData extends AttributeContainer implements KvmSerializable
{
	public DataSet				DataSet;

	public Integer				RowCount;

	public Boolean				Success;

	public String				Error;

	public String				ErrorInfo;

	public String				Status;

	public Boolean				StatusError;

	public ADLoginResponse		ADLoginResponse;

	public Integer				NumRows		= 0;

	public Integer				TotalRows	= 0;

	public Integer				StartRow	= 0;
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
		if (inObj.hasAttribute("NumRows"))
		{
			Object j = inObj.getAttribute("NumRows");
			if (j != null)
			{
				NumRows = Integer.parseInt(j.toString());
			}
		}
		if (inObj.hasAttribute("TotalRows"))
		{
			Object j = inObj.getAttribute("TotalRows");
			if (j != null)
			{
				TotalRows = Integer.parseInt(j.toString());
			}
		}
		if (inObj.hasAttribute("StartRow"))
		{
			Object j = inObj.getAttribute("StartRow");
			if (j != null)
			{
				StartRow = Integer.parseInt(j.toString());
			}
		}

	}

	protected boolean loadProperty(PropertyInfo info, SoapObject soapObject,
			ExtendedSoapSerializationEnvelope __envelope)
	{
		Object obj = info.getValue();
		if (info.name.equals("DataSet"))
		{
			if (obj != null)
			{
				Object j = obj;
				this.DataSet = (DataSet) __envelope.get(j, DataSet.class, false);
			}
			return true;
		}
		if (info.name.equals("RowCount"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.RowCount = Integer.parseInt(j.toString());
					}
				}
				else if (obj instanceof Integer)
				{
					this.RowCount = (Integer) obj;
				}
			}
			return true;
		}
		if (info.name.equals("Success"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.Success = new Boolean(j.toString());
					}
				}
				else if (obj instanceof Boolean)
				{
					this.Success = (Boolean) obj;
				}
			}
			return true;
		}
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
		if (info.name.equals("ErrorInfo"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.ErrorInfo = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.ErrorInfo = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("Status"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.Status = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.Status = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("StatusError"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.StatusError = new Boolean(j.toString());
					}
				}
				else if (obj instanceof Boolean)
				{
					this.StatusError = (Boolean) obj;
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
			return this.DataSet != null ? this.DataSet : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 1)
		{
			return this.RowCount != null ? this.RowCount : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 2)
		{
			return this.Success != null ? this.Success : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 3)
		{
			return this.Error != null ? this.Error : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 4)
		{
			return this.ErrorInfo != null ? this.ErrorInfo : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 5)
		{
			return this.Status != null ? this.Status : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 6)
		{
			return this.StatusError != null ? this.StatusError : SoapPrimitive.NullSkip;
		}
		if (propertyIndex == 7)
		{
			return this.ADLoginResponse != null ? this.ADLoginResponse : SoapPrimitive.NullSkip;
		}
		return null;
	}

	@Override
	public int getPropertyCount()
	{
		return 8;
	}

	@Override
	public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
	{
		if (propertyIndex == 0)
		{
			info.type = PropertyInfo.VECTOR_CLASS;
			info.name = "DataSet";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 1)
		{
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "RowCount";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 2)
		{
			info.type = PropertyInfo.BOOLEAN_CLASS;
			info.name = "Success";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 3)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Error";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 4)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "ErrorInfo";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 5)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Status";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 6)
		{
			info.type = PropertyInfo.BOOLEAN_CLASS;
			info.name = "StatusError";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 7)
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
			info.name = "NumRows";
			info.namespace = "";
			if (this.NumRows != null)
			{
				info.setValue(this.NumRows);
			}

		}
		if (index == 1)
		{
			info.name = "TotalRows";
			info.namespace = "";
			if (this.TotalRows != null)
			{
				info.setValue(this.TotalRows);
			}

		}
		if (index == 2)
		{
			info.name = "StartRow";
			info.namespace = "";
			if (this.StartRow != null)
			{
				info.setValue(this.StartRow);
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