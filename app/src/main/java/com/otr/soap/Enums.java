package com.otr.soap;

// ----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.2.8.1
//
// Created by Quasar Development
//
// ---------------------------------------------------

public class Enums
{

	public enum ModelCRUD_Action
	{

		Create(0),

		Read(1),

		Update(2),

		Delete(3),

		CreateUpdate(4);

		private int code;

		ModelCRUD_Action(int code)
		{
			this.code = code;
		}

		public int getCode()
		{
			return code;
		}

		public static ModelCRUD_Action fromString(String str)
		{
			if (str.equals("Create"))
				return Create;
			if (str.equals("Read"))
				return Read;
			if (str.equals("Update"))
				return Update;
			if (str.equals("Delete"))
				return Delete;
			if (str.equals("CreateUpdate"))
				return CreateUpdate;
			return null;
		}
	}

}