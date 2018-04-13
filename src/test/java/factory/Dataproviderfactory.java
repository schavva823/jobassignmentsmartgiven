package factory;

import dataprovider.Configdataprovider;
import dataprovider.ExcelDataprovider;

public class Dataproviderfactory 
{
public static Configdataprovider getconfig()
{
	Configdataprovider config=new Configdataprovider();
	return config;
}
public static ExcelDataprovider getExcel()
{
	ExcelDataprovider excel=new ExcelDataprovider();
	return excel;
}
}
