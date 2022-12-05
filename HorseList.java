import java.util.Scanner;

class HourseList{

    HorseNode head, tail;

    public void init(){
        head = tail = null;
    }

    public void register(int I, String hn, String JN){
        HorseNode h = new HorseNode();
        h.id = I;
        h.name = hn;
        h.Jname = JN;

        if(head == null){
            head = h;
            tail = h;
            tail.next = null;
        }else{
            head.next = h;
            tail = h;
            tail.next = null;
        }
    }

    public void show(){
        HorseNode a = head;
        System.out.println("|    Horse ID    |   Horse Name   |     Jockey Name  |    Round 01     |   Round 02    |  Round 03     |");
        while(a != null){
            System.out.println
                (
                " | " + a.id + " | " + a.name + " | " + a.Jname + " | " + a.r1_rank + " | " + a.r2_rank + " | " + a.r3_rank + " | " 
                );
            a = a.next;
        }
    }

    public void delete(int I){
        try {
            HorseNode a = head;
            HorseNode b = null;
            boolean found = false;

            while(a != null && found == false){
                if(a.id == I){
                    found = true;
                }else{
                   b = a;
                   a = a.next;
             }
            }

            if(found == false){
               System.out.println("Horse Not Found...");
            }else{
                System.out.println("Horse Found..");
                System.out.println("| Horse ID :" + a.id + "| Horse Name :" + a.name + "| Jockey Name :" + a.Jname + " | ");
                System.out.println("Are You Sure? (Y/N)");
                Scanner sc = new Scanner(System.in);
                String rep = sc.next();
                sc.close();
            
                if(rep.equals("Y")){
                    if(b == null){
                        head = head.next;
                    }
                    else{
                        b.next = a.next;        
                    }
                    System.out.println("Horse Deleted Successfully..");
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void round1() {
        System.out.println("Enter Round 01 results..");
        HorseNode p = head;
        Scanner sc = new Scanner(System.in);
        while(p != null){
            System.out.println("Enter Round 01 results for Horse ID: "+ p.id);
            p.r1_rank = sc.nextInt();
            p = p.next;
        }
        sc.close();        
    }

    public void round2() {
        System.out.println("Enter Round 02 results..");
        HorseNode p = head;
        Scanner sc = new Scanner(System.in);
        while(p != null){
            System.out.println("Enter Round 02 results for Horse ID: "+ p.id);
            p.r2_rank = sc.nextInt();
            p = p.next;
        }
        sc.close();        
    }

    public void round3() {
        System.out.println("Enter Round 03 results..");
        HorseNode p = head;
        Scanner sc = new Scanner(System.in);
        while(p != null){
            System.out.println("Enter Round 03 results for Horse ID: "+ p.id);
            p.r3_rank = sc.nextInt();
            p = p.next;
        }
        sc.close();        
    }

    public void removeRound1() {
        HorseNode p,maxNode;
        int max;
        p = head;
        maxNode = head;
        max = maxNode.r1_rank;

        while(p != null){
            if(max<p.r1_rank){
                maxNode = p;
                max = maxNode.r1_rank;
            }else{
                p = p.next;
            }
        }

        System.out.println("Removing Lowest Rank!..");
        delete(maxNode.id);
    }

    public void removeRound2() {
        HorseNode p,maxNode;
        int max;
        p = head;
        maxNode = head;
        max = maxNode.r2_rank;

        while(p != null){
            if(max<p.r2_rank){
                maxNode = p;
                max = maxNode.r2_rank;
            }else{
                p = p.next;
            }
        }

        System.out.println("Removing Lowest Rank!..");
        delete(maxNode.id);
    }

    public void removeRound3() {
        HorseNode p,maxNode;
        int max;
        p = head;
        maxNode = head;
        max = maxNode.r3_rank;

        while(p != null){
            if(max<p.r3_rank){
                maxNode = p;
                max = maxNode.r3_rank;
            }else{
                p = p.next;
            }
        }

        System.out.println("Removing Lowest Rank!..");
        delete(maxNode.id);
    }
public static void main(String args[]) {
    HourseList li = new HourseList();
    li.init();
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    while(choice != 7){
        System.out.println("-------Horse Race 2022---------");
		System.out.println("...............................");
		System.out.println("1.Register Horse details");
		System.out.println("2.Display Participants");
		System.out.println("3.Delete a Horse");
		System.out.println("4.Insert round results");
		System.out.println("5.Winners");
		System.out.println("6.Search a horse");
		System.out.println("7.Exit");
		System.out.println("Please select your option..(1,2,3)?");
		choice = sc.nextInt();

        if(choice == 1){
            System.out.println("------Register a horse--------");
			System.out.print("Horse name : ");
			String hn = sc.next();
			System.out.print("Jockey name : ");
			String jn = sc.next();
			System.out.print("Horse ID : ");
			int id = sc.nextInt();

			li.register(id,hn,jn);
        }

        

        if(choice == 2){
			System.out.println("-----------Horse details--------------");
			li.show();
		}

		if(choice == 3){
			System.out.println("-----------Deleting a horse--------------");
			System.out.println("Enter horse Id to be deleted..");
			int id = sc.nextInt();
			li.delete(id);
			
		}
		
		if(choice == 4){
			li.round1();
			li.show();

			li.round2();
			li.show();

			li.round3();
			li.show();
		}

		if(choice == 5){
			li.removeRound1();
		}
    }
    sc.close();

    
    
}

}