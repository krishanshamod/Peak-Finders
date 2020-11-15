public class Contact {
    private String name;
    private String phone;
 
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
 
    public String getname() {
        return this.name;
    }
 
    public String setname(){
        return (this.name = name);
    }
 
    
    public String getPhone() {
        return this.phone;
    }
 
    public String setPhone(){
        return (this.phone = phone);
    }
 
    
   
public void viewContacts() {
System.out.println(this.getname());
System.out.println(this.getPhone());
}
 
}