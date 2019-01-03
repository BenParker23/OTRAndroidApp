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

public class DataField extends AttributeContainer implements KvmSerializable
{

	public String				val;

	public LookupValues			lookup;

	public String				type;

	public String				column;

	public String				lval;

	public Boolean				disp;

	public Boolean				edit;

	public Boolean				error;

	public String				errorVal;
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
		if (inObj.hasAttribute("type"))
		{
			Object j = inObj.getAttribute("type");
			if (j != null)
			{
				type = j.toString();
			}
		}
		if (inObj.hasAttribute("column"))
		{
			Object j = inObj.getAttribute("column");
			if (j != null)
			{
				column = j.toString();
			}
		}
		if (inObj.hasAttribute("lval"))
		{
			Object j = inObj.getAttribute("lval");
			if (j != null)
			{
				lval = j.toString();
			}
		}
		if (inObj.hasAttribute("disp"))
		{
			Object j = inObj.getAttribute("disp");
			if (j != null)
			{
				disp = new Boolean(j.toString());
			}
		}
		if (inObj.hasAttribute("edit"))
		{
			Object j = inObj.getAttribute("edit");
			if (j != null)
			{
				edit = new Boolean(j.toString());
			}
		}
		if (inObj.hasAttribute("error"))
		{
			Object j = inObj.getAttribute("error");
			if (j != null)
			{
				error = new Boolean(j.toString());
			}
		}
		if (inObj.hasAttribute("errorVal"))
		{
			Object j = inObj.getAttribute("errorVal");
			if (j != null)
			{
				errorVal = j.toString();
			}
		}

	}

	protected boolean loadProperty(PropertyInfo info, SoapObject soapObject,
			ExtendedSoapSerializationEnvelope __envelope)
	{
		Object obj = info.getValue();
		if (info.name.equals("val"))
		{
			if (obj != null)
			{
				if (obj.getClass().equals(SoapPrimitive.class))
				{
					SoapPrimitive j = (SoapPrimitive) obj;
					if (j.toString() != null)
					{
						this.val = j.toString();
					}
				}
				else if (obj instanceof String)
				{
					this.val = (String) obj;
				}
			}
			return true;
		}
		if (info.name.equals("lookup"))
		{
			if (obj != null)
			{
				Object j = obj;
				this.lookup = (LookupValues) __envelope.get(j, LookupValues.class, false);
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
			return val;
		}
		if (propertyIndex == 1)
		{
			return this.lookup != null ? this.lookup : SoapPrimitive.NullSkip;
		}
		return null;
	}

	@Override
	public int getPropertyCount()
	{
		return 2;
	}

	@Override
	public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
	{
		if (propertyIndex == 0)
		{
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "val";
			info.namespace = "http://idempiere.org/ADInterface/1_0";
		}
		if (propertyIndex == 1)
		{
			info.type = PropertyInfo.VECTOR_CLASS;
			info.name = "lookup";
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
		return 7;
	}

	@Override
	public void getAttributeInfo(int index, AttributeInfo info)
	{
		if (index == 0)
		{
			info.name = "type";
			info.namespace = "";
			if (this.type != null)
			{
				info.setValue(this.type);
			}

		}
		if (index == 1)
		{
			info.name = "column";
			info.namespace = "";
			if (this.column != null)
			{
				info.setValue(this.column);
			}

		}
		if (index == 2)
		{
			info.name = "lval";
			info.namespace = "";
			if (this.lval != null)
			{
				info.setValue(this.lval);
			}

		}
		if (index == 3)
		{
			info.name = "disp";
			info.namespace = "";
			if (this.disp != null)
			{
				info.setValue(this.disp);
			}

		}
		if (index == 4)
		{
			info.name = "edit";
			info.namespace = "";
			if (this.edit != null)
			{
				info.setValue(this.edit);
			}

		}
		if (index == 5)
		{
			info.name = "error";
			info.namespace = "";
			if (this.error != null)
			{
				info.setValue(this.error);
			}

		}
		if (index == 6)
		{
			info.name = "errorVal";
			info.namespace = "";
			if (this.errorVal != null)
			{
				info.setValue(this.errorVal);
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