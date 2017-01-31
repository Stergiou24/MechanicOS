
public class PassingVar {
	public static String  language;
	public static String  mode;
	public static String idVal;
	public static String idDep;
	public static String idEmp;
	public static String jpos;
	public static boolean mng;
	public static boolean signupid;
	public void setLang(String lang)
	{
		language=lang;
	}
	public void setMode(String m)
	{
		mode=m;
	}
	public void setDepId(String idDeppassing)
	{
		idDep=idDeppassing;
	}
	public void setValId(String idValpassing)
	{
		idVal=idValpassing;
	}
	public void setEmpId(String idEmppassing)
	{
		idEmp=idEmppassing;
	}
	public void setMng(boolean signup)
	{
		mng=signup;
		System.out.println(mng);
	}
	public void setJPos(String job)
	{
		jpos=job;
	}
	public void SignUpId(boolean flag)
	{
		signupid=flag;
	}
}
