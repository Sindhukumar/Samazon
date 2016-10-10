
public class Users {
   private int userid;
   private String username; 
   private String userrole;   
   private String userpassword;  
   private String useremail;

   public Users() {}
   public Users(String username, String userrole, String userpassword, String useremail) {
      this.username = username;
      this.userrole = userrole;
      this.userpassword = userpassword;
      this.useremail = useremail;
   }
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserrole() {
	return userrole;
}
public void setUserrole(String userrole) {
	this.userrole = userrole;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getUseremail() {
	return useremail;
}
public void setUseremail(String useremail) {
	this.useremail = useremail;
}
}
