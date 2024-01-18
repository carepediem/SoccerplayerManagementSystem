

import java.util.*;


class Stat{
	private int stamina;
	private int dribble;
	private int shot;
	
	public Stat(int stamina,int dirbble, int shot) {
		this.stamina = stamina;
		this.dribble = dirbble;
		this.shot = shot;
	}
	
	public int getStamina() {
		return stamina;
	}
	public int getDribble() {
		return dribble;
	}
	public int getShot() {
		return shot;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public void setDribble(int dribble) {
		this.dribble = dribble;
	}
	public void setShot(int shot) {
	    this.shot = shot;	
	}
}

class Player{
	
	 private String name;
	 private int age;
	 private String country;
	 private String position;
	 private Stat s;
	
	public Player(String name, int age, String cty, String pos, int stamina, int dribble, int shot){
		this.name = name;
		this.age = age;
		this.country = cty;
		this.position = pos;
		this.s = new Stat(stamina, dribble, shot);
		
	}
	
	public  String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	public String getCountry() {
		return country;
	}
	public String getPosition() {
		return position;
	}
	public int getStatStamina() {
		return s.getStamina();
	}
	public int getStatDribble() {
		return s.getDribble();
	}
	public int getStatShot() {
		return s.getShot();
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setStatStamina(int stamina) {
		this.s.setStamina(stamina);
	}
	public void setStatDribble(int dribble) {
		this.s.setDribble(dribble);
	}
	public void setStatShot(int shot) {
		this.s.setShot(shot);
	}
	
	
}

class Training{
	
	Scanner scanner = new Scanner(System.in);
	
	public void runnning(Player p, int new_stamina) {
		int current_stamina = p.getStatStamina();
		p.setStatStamina(current_stamina+new_stamina);
	    System.out.println(p.getStatStamina()+ "(으)로 변경되었습니다");
	}
	
	public void lacroqueta(Player p, int new_dribble) {
		int current_dribble = p.getStatDribble();
		p.setStatDribble(current_dribble+new_dribble);
		 System.out.println(p.getStatDribble()+ "(으)로 변경되었습니다");
	}
	
	public void curlkick(Player p, int new_shot) {
		int current_shot = p.getStatShot();
		p.setStatShot(current_shot+new_shot);
		 System.out.println(p.getStatShot()+ "(으)로 변경되었습니다");
	}
} 


class User{
	private String Uid;
	private String Pwd;
	
	
	public User(String Uid, String Pwd) {
		this.Uid = Uid;
		this.Pwd  = Pwd;
	}
	
	
	boolean Correct(String InputId, String InputPw) {
		return this.Uid.equals(InputId) && this.Pwd.equals(InputPw);
	}
}




public class v1 {
	 
	
	 static ArrayList<Player> plist = new ArrayList<>();
	//  private static User loggedinUser = null;
	 static String[] pos = {"st","cf","lw","rw","lm","rm","cam","cm","cdm","cb","lb","rb","gk"};
	public static void main(String[] args) {
		
		
		 Scanner scanner = new Scanner(System.in);	
		 
		 System.out.println("1.Login");
		 System.out.println("2. End program");
		 
		 System.out.println("Select an option");
		 
		 while(true) {
			 int choice = scanner.nextInt();
		 
		 scanner.nextLine();
		 
		 switch(choice) {
		 case 1:
			 Login(scanner);
			 break;
		 case 2:
			 System.out.println("Bye Bye!");
				System.exit(0);
				break;
		 default:
				System.out.println("Please try correct option");
		
		 }

		 }
		 		
		
	}
	
	
	private static void Login(Scanner scanner) {
		
		User user1 = new User("admin", "admin123");
		User user2 = new User("root", "root123");
		 User[] users = {user1, user2};
		
		
		System.out.println("User name: ");
		String InputId = scanner.nextLine();
		
		System.out.println("User password: ");
		String InputPw = scanner.nextLine();
		
		for(User user : users) {
			if(user.Correct(InputId, InputPw)) {
				//loggedinUser = user;
				System.out.println("로그인 성공!");
				showMenu(scanner);
				return;
			}
		}
		
		System.out.println("로그인 정보가 잘못되었습니다");
		System.out.println("1.Login");
		System.out.println("2. End program");
		System.out.println("Select an option");
	}
	
	
	
	static void showMenu(Scanner scanner ) {
		System.out.println("Soccer Player Management System");
		System.out.println("1. Add player");
		System.out.println("2. Delete player");
		System.out.println("3. View player");
		System.out.println("4. Edit player");
		System.out.println("5. Training");
		System.out.println("6. End program");
		System.out.println("Select an option");
		
		while(true) {
			int choice = scanner.nextInt();
			
	
			scanner.nextLine();
			switch (choice) {
			case 1:
				  AddPlayer();
				  break;
			case 2:
				  DeletePlayer();
				  break;
			case 3:
			      ViewPlayer();
			      break;
			case 4:
			     EditPlayer();
			      break;
			case 5:
			     TrainingPlayer();
			      break;      
			case 6:
				System.out.println("Bye Bye!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Please try correct option");
				System.out.println();
			}
			
		}
		
	}
	
	
	
	static void AddPlayer(){ 
		
		Scanner scanner = new Scanner(System.in);
		String name, country, position = null;
		int age,stamina, dribble, shot;
		
		
		System.out.println("Player name: ");
		 name = scanner.next();
		
		System.out.println("Player age: ");
		 age = scanner.nextInt();			
		
		System.out.println("Player country: ");
		 country = scanner.next();			
		
		System.out.println("Player position: (st, cf, lw, rw, lm, rm, cam, cm, cdm, cb, lb, rb, gk)");
		
		
		while(true) {
			position = scanner.next();
			if(containPosition(pos, position)) {
				break;
			}
			else {
				System.out.println("올바른 포지션을 입력해주세요");
			}
		}
		
		System.out.println("Player stamina: ");
		 stamina = scanner.nextInt();
		
		System.out.println("Player dribble: ");
		 dribble = scanner.nextInt();
		
		System.out.println("Player shot: ");
		 shot = scanner.nextInt();
		
		Player p = new Player(name, age, country, position, stamina, dribble, shot);
		plist.add(p);
		
		System.out.println(p.getName() + "선수가 추가되었습니다");
		showMenu(scanner);
	}
	
	
	
	static void DeletePlayer() {
		
		Scanner scanner = new Scanner(System.in);
		if(plist.isEmpty()) {
			System.out.println("등록된 선수가 없습니다");
			return;
		}
		
		System.out.println("Player name: ");
		String playername = scanner.nextLine();
		
		Iterator<Player> it = plist.iterator();
		while(it.hasNext()) {
			Player player = it.next();
			if(player.getName().equals(playername)) {
				it.remove();
				System.out.println("선수가 삭제되었습니다");
				return;
			}
			else {
				System.out.println(playername +"선수가 없습니다");
			}
		}
		showMenu(scanner);
	}
	
	static void ViewPlayer() {
		Scanner scanner = new Scanner(System.in);
		if(plist.isEmpty()) {
			System.out.println("등록된 선수가 없습니다");
			System.out.println("선수를 추가해주세요");
		}
		else {
			System.out.println("================================================");
			System.out.println("선수 목록");
			for( Player p : plist) {
				
			    System.out.println("이름:"+ p.getName() + " 나이:"+p.getAge() +" 국적:"+p.getCountry()+ " 포지션:"+ p.getPosition()
				    +" 스태미너:"+ p.getStatStamina() +" 드리블:"+ p.getStatDribble()+ " 슛:"+ p.getStatShot());
			}
			System.out.println("================================================");
		}
		showMenu(scanner);
	}
	
	
	static void EditPlayer() {
		Scanner scanner = new Scanner(System.in);
		if(plist.isEmpty()) {
			System.out.println("등록된 선수가 없습니다");
			System.out.println("선수를 추가해주세요");
			showMenu(scanner);
		}
		else {
			System.out.println("Player name: ");
			String playername = scanner.nextLine();
			
			for(Player p : plist) {
				if(p.getName().equals(playername)) {
					System.out.println("수정하고 싶은 특성을 선택하세요");
					System.out.println("1.나이:"+p.getAge() +" 2.국적:"+p.getCountry()+ " 3.포지션:"+ p.getPosition());
					
					int choice = scanner.nextInt();
					switch(choice) {
					case 1:
				
						System.out.println("변경할 나이를 입력해주세요");
						int new_age = scanner.nextInt();
						p.setAge(new_age); 
					    System.out.println(p.getAge()+ "(으)로 변경되었습니다");
					    showMenu(scanner);
					case 2:
						
						System.out.println("변경할 국적을 입력해주세요");
						String new_country = scanner.next();
						p.setCountry(new_country); 
					    System.out.println(p.getCountry()+ "(으)로 변경되었습니다");
					    showMenu(scanner);
					case 3:
						
						System.out.println("변경할 포지션을 입력해주세요");
						while(true) {
							String new_position = scanner.next();
							if(containPosition(pos, new_position)) {
								p.setPosition(new_position);
								System.out.println(p.getPosition()+ "(으)로 변경되었습니다");
								showMenu(scanner);
							}
							else {
								System.out.println("올바른 포지션을 입력해주세요");
							}
						}
					default:
						System.out.println("Please try correct option");
						System.out.println();
					}	
						
					    
					}
					
				}
				
			}
			
		}
	
	
	static boolean containPosition(String[] pos, String position) {
		  for(String str : pos) {
			  if(str.equals(position)) {
				  return true;
			  }
		  }
		  return false;
	}
	
	static void TrainingPlayer() {
		Scanner scanner = new Scanner(System.in);
		if(plist.isEmpty()) {
			System.out.println("등록된 선수가 없습니다");
			System.out.println("선수를 추가해주세요");
			showMenu(scanner);
		}
		else {
			System.out.println("Player name: ");
			String playername = scanner.nextLine();
			Training train = new Training();
			
			for(Player p : plist) {
				if(p.getName().equals(playername)) {
					System.out.println("원하는 훈련세션을 선택하세요");
					System.out.println("1.Stamina(Running):"+p.getStatStamina() +" 2.Dribble(RaCroqueta):"+p.getStatDribble()+
							" 3.Shot(Crulkick):"+ p.getStatShot());
					
					int choice = scanner.nextInt();
					switch(choice) {
					case 1:
						System.out.println("훈련 강도를 입력해주세요");
						int new_stamina = scanner.nextInt();
						train.runnning(p, new_stamina);
					    showMenu(scanner);
				
						
					case 2:
						System.out.println("훈련 강도를 입력해주세요");
						int new_dribble = scanner.nextInt();
						train.lacroqueta(p, new_dribble);
					    showMenu(scanner);
						
					case 3:
						System.out.println("훈련 강도를 입력해주세요");
						int new_shot = scanner.nextInt();
						train.curlkick(p, new_shot);
					    showMenu(scanner);
					default:
						System.out.println("Please try correct option");
						System.out.println();
					}	
					
				}
				
			}
			
		}
		
		
	}

} 

 
