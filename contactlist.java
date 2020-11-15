 import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
 
    public class contactlist {
 
    /*ArrayList<List.Contact> contactlist;*/
 
    List<Contact> contactlist = new ArrayList<>();
 
 
    /* Contact contact; */
    private int top = 0;
 
    public static void main(String[] args) throws IOException {
        /* Contact contact;
        contact = new Contact();
        List.Contact c;
        c = contact; */
        contactlist list = new contactlist();
 
        BufferedReader keyIn;
        keyIn = new BufferedReader(new InputStreamReader(System.in));
        String choose = "";
        while (true) {
 
            
            System.out.println("[1]  display all contacts");
            System.out.println("\n[2] Add contact");
            System.out.println("\n[3] remove contact");
            System.out.println("\n[4] edit contact");
            System.out.println("\n[5] load contacts from a text file");
            System.out.println("\n[6] save contacts to the text file");
            System.out.println("[7] Quit");
            System.out.print("Choose : ");
 
            try {
                choose = keyIn.readLine();
            } catch (IOException e) {
 
                System.out.println("Error");
            }
            switch (choose) {
                case "1":
                	list.viewContacts();
                    break;
                   
                case "2":
                	 list.addContact();
                     break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error");
                    break;
             }
 
           }
        }
 
    public contactlist() {
        this.contactlist = new ArrayList<>();
    }
 
    public void addContact() throws IOException {
        BufferedReader keyIn;
        keyIn = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String phone;
 
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter name and phone number: ");
            System.out.print("Name: ");
            name = keyIn.readLine();
            System.out.print("Phone number: ");
            phone = keyIn.readLine();
           
    }
 
    public void view() {
    for (int index = 0; index < top; index++) {
        contactlist.get(index).viewContacts();
        }
        }
 
    private void viewContacts() {
        System.out.println(contactlist);
    }
    }