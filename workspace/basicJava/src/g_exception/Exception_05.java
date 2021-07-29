package g_exception;

import java.sql.SQLException;

public class Exception_05 {
	public static void main(String[] args){
		Controller.controllerMethod();
	}
}

class Controller{
	static void controllerMethod(){
		Service.serviceMethod();
	
	}
}

class Service{
	static void serviceMethod(){
		
		try {
			Dao.daoMethod();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

class Dao{
	static void daoMethod() throws SQLException, Exception{
		throw new SQLException();
	}
}
