import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class mainfile {
    public static void main(String[] args){
        String nameInput,phoneNoInput;
        Scanner scan = new Scanner(System.in);
        ContactList list1 = new ContactList();
        

        for(;;){
        System.out.println("Select an Option: ");
        System.out.println("Enter 1 to display all contacts \nEnter 2 to add contact \nEnter 3 to remove contact \nEnter 4 to edit a contact \nEnter 5 to load contacts from a text file \nEnter 6 to save contacts to the text file \nEnter 7 to exit from the program");
        int i = scan.nextInt();

        if(i==1){
            list1.displayContacts();
        }
        else if(i==2){
            System.out.println("Please enter name: ");
            nameInput = scan.next();
            System.out.println("Please add phone number: ");
            phoneNoInput = scan.next();   
            list1.addContact(nameInput, phoneNoInput);
        }
        else if(i==3){
            System.out.println("Please enter name of the contact that you want to delete: ");
            nameInput = scan.next();
            list1.deleteContact(nameInput);

        }
        else if(i==4){
            System.out.println("Please enter name of the contact that you want to change: ");
            nameInput = scan.next();
            System.out.println("Please enter the new phone number: ");
            phoneNoInput = scan.next(); 
            list1.editContact(nameInput, phoneNoInput);
        }
        else if(i==5){
            list1.loadContacts();
        }
        else if(i==6){
            list1.saveContacts();
        }
        else if(i==7){
            break;
        }
        }
    }
}

class Contact{
    private String name;
    private String phoneNo;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo(){
        return phoneNo;
    }
}

class ContactList{
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<String> noList = new ArrayList<String>();

    public void addContact(String name, String phoneNo){
        list.add(name + " " + phoneNo);
        nameList.add(name);
        noList.add(phoneNo);
    }

    public void deleteContact(String name){
        for(int i=0;i<list.size();i++){
            if(name.equals(nameList.get(i))){
                list.remove(i);
                nameList.remove(i);
                noList.remove(i);
                break;
            }
        }
    }

    public void editContact(String name, String phoneNo){

        for(int i=0;i<list.size();i++){
            if(name.equals(nameList.get(i))){
                list.set(i,name + " " + phoneNo);
                noList.set(i,phoneNo);
                break;
            }
        }
    }

    public void displayContacts(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public void loadContacts(){
        
        try {
            File file = new File("contactlist.txt");
            file.createNewFile();

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          try {
            File file = new File("contactlist.txt");
            Scanner scan = new Scanner(file);
          while (scan.hasNextLine()) {
            String scanName = scan.next();
            String scanNo = scan.next();

            list.add(scanName + " " + scanNo);
            nameList.add(scanName);
            noList.add(scanNo);
            
          }
          scan.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          
        

    }

    public void saveContacts(){
        try {
            FileWriter writeFile = new FileWriter("contactlist.txt");
            
            for(int i=0;i<list.size();i++){
                writeFile.write(list.get(i));
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}