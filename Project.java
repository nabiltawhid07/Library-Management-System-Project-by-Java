import java.util.Arrays;
import java.util.Scanner;
public class Project{
    static String[]arr={"The Hobbit","Animal Farm","The Alchemist","A Brief History of Time","Clean Code","Introduction to Algorithms","The C Programming Language","Java: The Complete Reference","The Great Gatsby","Pride and Prejudice"};
    static int[] assignedDates=new int[5];
    static int []returnDates=new int[5];
    static int[] DueDates=new int[5];
    static String[]members={"Alex","Jason","Max","John","Tom"};
    static int [] Fines=new int[5];
    static String[]borrowedBooks=new String [5];
    static String []ids={"LIB001","LIB002","LIB003","LIB004","LIB005"};
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("|   Library Management System   |");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("1. Show all Books ");
        System.out.println("2. Search Book ");
        System.out.println("3. Add books");
        System.out.println("4. Remove books");
        System.out.println("5. Sort books");
        System.out.println("6. Assign Books");
        System.out.println("7. Show all members");
        System.out.println("8. Borrowing History");
        System.out.println("9. Fines");
        System.out.println("10. Due dates");
        System.out.println("11. Take Return");
        System.out.println("");
        All_options();
    }
    public static void All_options() {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your choice(1 to 11): ");
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
        }
    }
    public static void ShowAllBooks(){
        System.out.println();
        for(int i=0;i< arr.length;i++){
            System.out.println((i+1)+". "+arr[i]);
        }
        All_options();
    }
    public static void SearchBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.print("Search book: ");
        String book=sc.nextLine();
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            if(book.equals(arr[i])){
                flag=true;
                break;
            }
        }
        if(flag==false){
            System.out.println("Not Available");
        }
        else{
            System.out.println("Available");
        }
        All_options();
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
        System.out.print("Enter the names of the new books: ");
        for(int m=0;m<added;m++){
            String newBooks=sc.nextLine();
            newArr[size+m]=newBooks;
        }
        arr=newArr;
        System.out.println("Updated list of books: ");
        for(int j=0;j<newArr.length;j++){
            System.out.println((j+1)+". "+arr[j]);
        }
        All_options();
    }
    public static void RemoveBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.println("The current book list is: ");
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
        System.out.print("Enter the serial numbers: ");
        for(int i=0;i<remove;i++){
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
        All_options();
    }
    public static void SortBooks(){
        System.out.println();
        Scanner sc=new Scanner(System.in);
        AlphabeticalOrder();
        All_options();
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
        All_options();
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
        All_options();
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
        All_options();
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
        All_options();
    }
    public static void AllMembers(){
        System.out.println();
        System.out.println("List of all library Members: ");
        System.out.println();
        for(int i=0;i< members.length;i++){
            System.out.println((i+1)+". "+members[i]+" -ID: "+ids[i]);
        }
        All_options();
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
        All_options();
    }
    public static void Fines(){
        System.out.println("Here is the list of members along with their respective overdue fines: ");
        for(int i=0;i< members.length;i++) {
            System.out.println();
            System.out.println("Name: " + members[i]);
            System.out.println("ID: " + ids[i]);
            System.out.println("Fine: "+Fines[i]+" taka");
        }
        All_options();
    }
}
