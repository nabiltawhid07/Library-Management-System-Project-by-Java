import java.util.Arrays;
import java.util.Scanner;
public class Project{
    static String[]arr={"The Hobbit","Animal Farm","The Alchemist","A Brief History of Time","Clean Code","Introduction to Algorithms","The C Programming Language","Java: The Complete Reference","The Great Gatsby","Pride and Prejudice"};
    static double[]rating={5,4.7,4.8,4.3,4.2,3.7,2.8,4.1,3.3,4.4};
    static int[] assignedDates=new int[5];
    static int []returnDates=new int[5];
    static int[] DueDates=new int[5];
    static String[]members={"Alex","Jason","Max","John","Tom"};
    static int [] Fines=new int[5];
    static String[]borrowedBooks=new String [5];
    static String []ids={"LIB001","LIB002","LIB003","LIB004","LIB005"};
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║              ADMIN LOGIN             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Enter Admin credentials: ");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        if(username.equals("admin") && password.equals("password")){
            Menu();
        }
        else{
            System.out.println("The username or password is incorrect.");
        }
    }
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       LIBRARY MANAGEMENT SYSTEM      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("");
        System.out.println("1. Show all Books ");
        System.out.println("2. Search Book ");
        System.out.println("3. Add Books");
        System.out.println("4. Remove Books");
        System.out.println("5. Sort Books");
        System.out.println("6. Assign Books");
        System.out.println("7. Show all Members");
        System.out.println("8. Borrowing History");
        System.out.println("9. Fines");
        System.out.println("10. Due Dates");
        System.out.println("11. Take Return");
        System.out.println("12. Add Members");
        System.out.println("13. Remove Members");
        System.out.println("");
        All_options();
    }
    public static void All_options() {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your choice(1 to 13): ");
        int MenuInput = sc.nextInt();
        if (MenuInput == 1) {
            ShowAllBooks();
        } else if (MenuInput == 2) {
            SearchBooks();
        } else if (MenuInput == 3) {
            AddBooks();
        } else if (MenuInput == 4) {
            RemoveBooks();
        } else if (MenuInput == 5) {
            SortBooks();
        } else if (MenuInput == 6) {
            AssignBooks();
        } else if (MenuInput == 7) {
            AllMembers();
        } else if (MenuInput == 8) {
            Borrowing_History();
        } else if (MenuInput == 9) {
            Fines();
        } else if(MenuInput==10){
            Duedates();
        } else if(MenuInput==11) {
            TakeReturn();
        }else if(MenuInput==12){
            AddMembers();
        }else if(MenuInput==13){
            RemoveMembers();
        }
    }
    public static void ShowAllBooks(){
        System.out.println();
        for(int i=0;i< arr.length;i++){
            System.out.println((i+1)+". "+arr[i]);
        }
        Menu();
    }
    public static void SearchBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.print("Search book: ");
        String book=sc.nextLine();
        boolean flag=false;
        int i=0;
        for( i=0;i<arr.length;i++){
            if(book.equals(arr[i])){
                flag=true;
                break;
            }
        }
        if(flag==false){
            System.out.println();
            System.out.println("Sorry, Not Available");
        }
        else{
            System.out.println();
            System.out.println("Yes, Available--It's in serial number "+(i+1));
        }
        Menu();
    }
    public static void AddBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        int count=0;
        for(int m=0;m<arr.length;m++){
            count++;
        }
        int size=count;
        System.out.print("Enter the amount of books to be added: ");
        int added=sc.nextInt();
        String leftoverEater=sc.nextLine();  //To consume the extra ' '
        String []newArr=new String[size+added];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        for(int m=0;m<added;m++){
            System.out.print("Enter the name of book no. "+(m+1)+": ");
            String newBooks=sc.nextLine();
            newArr[size+m]=newBooks;
        }
        arr=newArr;
        System.out.println("Updated list of books: ");
        for(int j=0;j<newArr.length;j++){
            System.out.println((j+1)+". "+arr[j]);
        }
        Menu();
    }
    public static void RemoveBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.println("The current book list: ");
        System.out.println("");
        for(int n=0;n< arr.length;n++){
            System.out.println((n+1)+". "+arr[n]);
        }
        System.out.println("");
        System.out.println("");
        System.out.print("Enter the amount of books to remove: ");
        int remove=sc.nextInt();
        int count=0;
        for(int m=0;m<arr.length;m++){
            count++;
        }
        int size=count;
        for(int i=0;i<remove;i++){
            System.out.print("Enter the serial number: ");
            int options=sc.nextInt();
            int options2=options-i;
            String []newArr=new String[size-1];
            for(int j=0;j<options2-1;j++){
                newArr[j]=arr[j];
            }
            for(int k=options2-1;k< newArr.length;k++){
                newArr[k]=arr[k+1];
            }
            arr=newArr;
            size=size-1;  //after every iteration, size of the array will decrease by 1
        }
        System.out.println("");
        System.out.println("Updated book list: ");
        for(int m=0;m< arr.length;m++){
            System.out.println((m+1)+". "+arr[m]);
        }
        Menu();
    }
    public static void SortBooks(){
        System.out.println();
        System.out.println("How do you want to sort by?");
        System.out.println("1. Alphabetical Order");
        System.out.println("2. Ratings");
        System.out.println();
        System.out.print("Choose your option: ");
        Scanner sc=new Scanner(System.in);
        int choose=sc.nextInt();
        if(choose==1){
            AlphabeticalOrder();
        }
        else if(choose==2){
            Rating();
        }
        Menu();
    }
    public static void AlphabeticalOrder(){
        System.out.println();
        int count=0;
        for(int m=0;m<arr.length;m++){
            count++;
        }
        int size=count;
        int []newArr=new int[size];
        for(int i=0;i<arr.length;i++){
            String elem=arr[i];
            char c = elem.charAt(0);
            newArr[i]=(c);
        }
        for(int i=0;i<newArr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<newArr.length;j++){
                if(newArr[j]<newArr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=newArr[i];
            String temp2=arr[i];
            newArr[i]=newArr[minIndex];
            arr[i]=arr[minIndex];
            newArr[minIndex]=temp;
            arr[minIndex]=temp2;
        }
        System.out.println();
        System.out.println("Sorted by Alphabetical Order: ");
        System.out.println();
        for(int i=0;i< arr.length;i++){
            System.out.println((i+1)+". "+arr[i]);
        }
        Menu();
    }
    public static void Rating(){
        for(int i=0;i<rating.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]>rating[minIndex]){
                    minIndex=j;
                }
            }
            double temp=rating[i];
            String temp2=arr[i];
            rating[i]=rating[minIndex];
            arr[i]=arr[minIndex];
            rating[minIndex]=temp;
            arr[minIndex]=temp2;
        }
        System.out.println();
        System.out.println("Sorted by Ratings: ");
        System.out.println();
        for(int i=0;i< arr.length;i++){
            System.out.println((i+1)+". "+arr[i]+"-- Rating: "+rating[i]+"★");
        }
        Menu();
    }
    public static void AssignBooks(){
        System.out.println();
        System.out.println("List of all library Members: ");
        System.out.println();
        for(int i=0;i< members.length;i++){
            System.out.println((i+1)+". "+members[i]+" -ID: "+ids[i]);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.print("Assign books to how many members?: ");
        int person=sc.nextInt();
        String LeftOverEater=sc.nextLine();
        for(int i=1;i<=person;i++){
            System.out.print("Write the ID of the member: ");
            String id=sc.nextLine();
            boolean flag=false;
            int MemberIdx=0;
            for(int j=0;j< ids.length;j++){
                if(id.equals(ids[j])){
                    flag=true;
                    MemberIdx=j;
                    break;
                }
            }
            if(flag==false){
                System.out.println("This person is not a member");
                break;
            }
            System.out.println();
            System.out.println("Here are the list of all books: ");
            System.out.println();
            for(int n=0;n< arr.length;n++){
                System.out.println((n+1)+". "+arr[n]);
            }
            System.out.println();
            System.out.print("Which book do you want to assign? Enter it's serial number: ");
            int sl=sc.nextInt();
            borrowedBooks[MemberIdx]=arr[sl-1];
            int count=0;
            for(int m=0;m< arr.length;m++){
                count++;
            }
            int size=count;
            String []newArr=new String[size-1];
            for(int j=0;j<sl-1;j++){
                newArr[j]=arr[j];
            }
            for(int k=sl-1;k< newArr.length;k++){
                newArr[k]=arr[k+1];
            }
            arr=newArr;
            System.out.print("The date you are assinging(1 to 30): ");
            int date=sc.nextInt();
            if(date>0 && date<=30){
            }
            else{
                System.out.println("Enter a valid date");
                break;
            }
            assignedDates[MemberIdx]=date;
            int dueDate=0;
            if(date>0 && date<=20){
                dueDate=date+10;
            }
            else if(date>20 && date<=30){
                dueDate=date+10-30;
            }
            DueDates[MemberIdx]=dueDate;
            System.out.println();
            System.out.println(borrowedBooks[MemberIdx]+" book has been assigned to ID no.-"+ids[MemberIdx]+", Name: "+members[MemberIdx]);
            String LeftoverEater=sc.nextLine();
        }
        Menu();
    }
    public static void Borrowing_History(){
        System.out.println("Here is the list of all members with their respective borrowing history: ");
        System.out.println();
        for(int i=0;i< members.length;i++){
            System.out.println("Name: "+members[i]);
            System.out.println("ID: "+ids[i]);
            System.out.println("Borrowed book: "+borrowedBooks[i]);

            if(assignedDates[i]==0){
                System.out.println("Book borrowed on: --");
            }
            else{
                System.out.println("Book borrowed on: "+assignedDates[i]+" September 2026");
            }
            System.out.println();
        }
        Menu();
    }
    public static void Duedates(){
        System.out.println("Here is the all members with their respective due dates:  ");
        for(int i=0;i< members.length;i++){
            System.out.println();
            System.out.println("Name: "+members[i]);
            System.out.println("ID: "+ids[i]);
            if(DueDates[i]==0){
                System.out.println("No due dates");
            }
            else if(DueDates[i]>0 && DueDates[i]<=10){
                System.out.println("Due date: "+DueDates[i]+" October 2026");
            }
            else if(DueDates[i]>10 && DueDates[i]<=30){
                System.out.println("Due date: "+DueDates[i]+" September 2026");
            }
            System.out.println("Borrowed book: "+borrowedBooks[i]);

        }
        Menu();
    }
    public static void AllMembers(){
        System.out.println();
        System.out.println("List of all library Members: ");
        System.out.println();
        for(int i=0;i< members.length;i++){
            System.out.println((i+1)+". "+members[i]+" -ID: "+ids[i]);
        }
        Menu();
    }
    public static void TakeReturn(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.print("How many persons will return book?: ");
        int person=sc.nextInt();
        String LeftOverEater=sc.nextLine();
        for(int i=1;i<=person;i++) {
            System.out.print("Write the ID of the member: ");
            String id = sc.nextLine();
            boolean flag = false;
            int MemberIdx = 0;
            for (int j = 0; j < ids.length; j++) {
                if (id.equals(ids[j])) {
                    flag = true;
                    MemberIdx = j;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("This person is not a member");
                break;
            }
            System.out.print("Which book is being returned? Enter the name: ");
            String returnBook=sc.nextLine();
            borrowedBooks[MemberIdx]=null;
            int DueDates2=DueDates[MemberIdx];
            DueDates[MemberIdx]=0;
            int count=0;
            for(int m=0;m<arr.length;m++){
                count++;
            }
            int size=count;
            String []newArr=new String[size+1];
            for(int k=0;k<arr.length;k++){
                newArr[k]=arr[k];
            }
            newArr[size]=returnBook;
            arr=newArr;
            System.out.print("The date when the book is being returned(1 to 30): ");
            int returnDate=sc.nextInt();
            returnDates[MemberIdx]=returnDate;
            if(returnDates[MemberIdx]>DueDates2 && returnDates[MemberIdx]<=30){
                Fines[MemberIdx]=50+((returnDates[MemberIdx]-DueDates2)*2);
            }
            else if(returnDates[MemberIdx]<=DueDates2){
                Fines[MemberIdx]=0;
            }
            String LeftoverEater=sc.nextLine();
        }
        Menu();
    }
    public static void Fines(){
        System.out.println("Here is the list of members along with their respective overdue fines: ");
        for(int i=0;i< members.length;i++) {
            System.out.println();
            System.out.println("Name: " + members[i]);
            System.out.println("ID: " + ids[i]);
            System.out.println("Fine: "+Fines[i]+" taka");
        }
        Menu();
    }
    public static void AddMembers(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        int count=0;
        for(int m=0;m<members.length;m++){
            count++;
        }
        int size=count;
        System.out.print("Enter the amount of Members to be added: ");
        int added=sc.nextInt();
        String leftoverEater=sc.nextLine();  //To consume the extra ' '
        String []newArr=new String[size+added];
        String []newArrID=new String[size+added];
        for(int i=0;i<members.length;i++){
            newArr[i]=members[i];
            newArrID[i]=ids[i];
        }
        for(int m=0;m<added;m++){
            System.out.print("Enter the name of new Member-"+(m+1)+": ");
            String newMembers=sc.nextLine();
            newArr[size+m]=newMembers;
            System.out.print("Set an ID for the new Member-"+(m+1)+": ");
            String newId=sc.nextLine();
            newArrID[size+m]=newId;
        }
        members=newArr;
        ids=newArrID;
        System.out.println("Updated list of Members: ");
        for(int j=0;j<newArr.length;j++){
            System.out.println((j+1)+". "+members[j]+"--ID: "+ids[j]);
        }
        Menu();
    }
    public static void RemoveMembers(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.println("The current list of all Members: ");
        System.out.println("");
        for(int n=0;n< members.length;n++){
            System.out.println((n+1)+". "+members[n]+" --ID: "+ids[n]);
        }
        System.out.println("");
        System.out.println("");
        System.out.print("Enter the amount of Members to remove: ");
        int remove=sc.nextInt();
        int count=0;
        for(int m=0;m<members.length;m++){
            count++;
        }
        int size=count;
        int options=0;
        String LeftoverEater=sc.nextLine();
        for(int i=0;i<remove;i++){
            System.out.print("Enter the ID of the Member: ");
            String id=sc.nextLine();
            for(int p=0;p< ids.length;p++){
                if(id.equals(ids[p])){
                    options=(p+1);
                }
            }
            int options2=options;
            String []newArr=new String[size-1];
            String []newArr2=new String[size-1];
            for(int j=0;j<options2-1;j++){
                newArr[j]=members[j];
                newArr2[j]=ids[j];
            }
            for(int k=options2-1;k< newArr.length;k++){
                newArr[k]=members[k+1];
                newArr2[k]=ids[k+1];
            }
            members=newArr;
            ids=newArr2;
            size=size-1;
            //String LeftOverEater=sc.nextLine();//after every iteration, size of the array will decrease by 1
        }
        System.out.println("");
        System.out.println("Updated list of all Members: ");
        for(int m=0;m< members.length;m++){
            System.out.println((m+1)+". "+members[m]+" --ID :"+ids[m]);
        }
        Menu();
    }
}

