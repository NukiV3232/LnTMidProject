//LnT Mid Project (JAVA)
//Nama : Nuki Venoza
//NIM  : 2440027026

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MidProjectLnT {
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<String> namaArr = new ArrayList<>();
	ArrayList<String> jenisKelaminArr = new ArrayList<>();
	ArrayList<String> jabatanArr = new ArrayList<>();
	ArrayList<String> IDArr = new ArrayList<>();
	ArrayList<Double> gajiArr = new ArrayList<>();
	
	ArrayList<String> managerArr = new ArrayList<>();
	ArrayList<String> supervisorArr = new ArrayList<>();
	ArrayList<String> adminArr = new ArrayList<>();
	
	ArrayList<String> managerIDArr = new ArrayList<>();
	ArrayList<String> supervisorIDArr = new ArrayList<>();
	ArrayList<String> adminIDArr = new ArrayList<>();

	public MidProjectLnT() {
		menu();
	}

	public static void main(String[] args) {
		new MidProjectLnT();
	}
	
	public void menu() {
		 int choose = -1;
		 System.out.println("PT. Mentol");
		 System.out.println("==========");
		 System.out.println("1. Insert Data Karyawan");
		 System.out.println("2. View Data Karyawan");
		 System.out.println("3. Update Data Karyawan");
		 System.out.println("4. Delete Data Karyawan");
		 System.out.println("5. Exit");
		 
		 do {
			try {
				System.out.print(">> ");
				choose = sc.nextInt();
			} catch (Exception e) {
				
			}sc.nextLine();
		} while (choose < 1 || choose > 5);
		
		switch (choose) {
		case 1:
			insertKaryawan();
			break;
		
		case 2:
			viewKaryawan();
			break;
			
		case 3:
			updateKaryawan();
			break;
			
		case 4:
			deleteKaryawan();
			break;
		
		case 5:
			System.exit(0);
		} 
	}
	
	public void insertKaryawan() {
		String nama = "", jenisKelamin = "", jabatan = "", ID = "";
		double gaji = 0.0;
		
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = sc.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenisKelamin = sc.nextLine();
		} while (!jenisKelamin.equals("Laki-laki") && !jenisKelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
		Random rand = new Random();
		ID = "" + (char)('A' + rand.nextInt(26)) + (char)('A' + rand.nextInt(26)) + "-" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + + rand.nextInt(10);
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			managerArr.add(jabatan);
			managerIDArr.add(ID);
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			supervisorArr.add(jabatan);
			supervisorIDArr.add(ID);
		}
		else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			adminArr.add(jabatan);
			adminIDArr.add(ID);
		}
		
		namaArr.add(nama);
		jenisKelaminArr.add(jenisKelamin);
		jabatanArr.add(jabatan);
		IDArr.add(ID);
		gajiArr.add(gaji);
		
		if (managerArr.size() % 3 == 0 && managerArr.size() != 0) {
			for (int i = 0; i < managerArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 10 / 100)));
			}
			System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan id " + (managerIDArr.toString().replace("[", "").replace("]", "")));
		}
		
		if (supervisorArr.size() % 3 == 0 && supervisorArr.size() != 0) {
			for (int i = 0; i < supervisorArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 7.5 / 100)));
			}
			System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + (supervisorIDArr.toString().replace("[", "").replace("]", "")));
		}
		
		if (adminArr.size() % 3 == 0 && adminArr.size() != 0) {
			for (int i = 0; i < adminArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 5 / 100)));
			}
			System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan id " + (adminIDArr.toString().replace("[", "").replace("]", "")));
		}
		
		System.out.println("ENTER to return");
		sc.nextLine();
		menu();
	}
	
	public void viewKaryawan() {
		String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "";
		double tempGaji = 0.0;
		
		if (namaArr.size() == 0) {
			System.out.println("No Karyawan found!");
			System.out.println("ENTER to return");
			sc.nextLine();
			menu();
		}
		else {
			for (int i = 0; i < namaArr.size() - 1; i++) {
				for (int j = i + 1; j < namaArr.size(); j++) {
					if (namaArr.get(i).compareToIgnoreCase(namaArr.get(j)) > 0) {
						tempNama = namaArr.get(i);
						namaArr.set(i, namaArr.get(j));
						namaArr.set(j, tempNama);

						tempJenisKelamin = jenisKelaminArr.get(i);
						jenisKelaminArr.set(i, jenisKelaminArr.get(j));
						jenisKelaminArr.set(j, tempJenisKelamin);

						tempJabatan = jabatanArr.get(i);
						jabatanArr.set(i, jabatanArr.get(j));
						jabatanArr.set(j, tempJabatan);
						
						tempID = IDArr.get(i);
						IDArr.set(i, IDArr.get(j));
						IDArr.set(j, tempID);
						
						tempGaji = gajiArr.get(i);
						gajiArr.set(i, gajiArr.get(j));
						gajiArr.set(j, tempGaji);

					}
				}
			}
			
			for (int i = 0; i < namaArr.size(); i++) {
				System.out.println("No." + (i+1));
				System.out.println("Kode Karyawan : " + IDArr.get(i));
				System.out.println("Nama Karyawan : " + namaArr.get(i));
				System.out.println("Jenis Kelamin : " + jenisKelaminArr.get(i));
				System.out.println("Jabatan       : " + jabatanArr.get(i));
				System.out.println("Gaji Karyawan : " + gajiArr.get(i));
				System.out.println("");
			}
			System.out.println("");
			menu();
		
		}
	}
	
	public void updateKaryawan() {
		String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "", nama = "", jenisKelamin = "", jabatan = "", ID = "";;
		int number = -1;
		double gaji = 0.0, tempGaji = 0.0;
		
		if (namaArr.size() == 0) {
			System.out.println("No Karyawan found!");
			System.out.println("ENTER to return");
			sc.nextLine();
			menu();
		}
		
		else {
			for (int i = 0; i < namaArr.size() - 1; i++) {
				for (int j = i + 1; j < namaArr.size(); j++) {
					if (namaArr.get(i).compareToIgnoreCase(namaArr.get(j)) > 0) {
						tempNama = namaArr.get(i);
						namaArr.set(i, namaArr.get(j));
						namaArr.set(j, tempNama);

						tempJenisKelamin = jenisKelaminArr.get(i);
						jenisKelaminArr.set(i, jenisKelaminArr.get(j));
						jenisKelaminArr.set(j, tempJenisKelamin);

						tempJabatan = jabatanArr.get(i);
						jabatanArr.set(i, jabatanArr.get(j));
						jabatanArr.set(j, tempJabatan);
						
						tempID = IDArr.get(i);
						IDArr.set(i, IDArr.get(j));
						IDArr.set(j, tempID);
						
						tempGaji = gajiArr.get(i);
						gajiArr.set(i, gajiArr.get(j));
						gajiArr.set(j, tempGaji);

					}
				}
			}
			
			for (int i = 0; i < namaArr.size(); i++) {
				System.out.println("No." + (i+1));
				System.out.println("Kode Karyawan : " + IDArr.get(i));
				System.out.println("Nama Karyawan : " + namaArr.get(i));
				System.out.println("Jenis Kelamin : " + jenisKelaminArr.get(i));
				System.out.println("Jabatan       : " + jabatanArr.get(i));
				System.out.println("Gaji Karyawan : " + gajiArr.get(i));
				System.out.println("");
			}
			
			do {
				try {
					System.out.print("Pilih nomor karyawan yang ingin diupdate [1..."+ namaArr.size() +"]: ");
					number = sc.nextInt();
				} catch (Exception e) {
					
				}sc.nextLine();
			} while (number < 1 || number > namaArr.size());
			
			
			do {
				System.out.print("Input nama karyawan [>= 3]: ");
				nama = sc.nextLine();
			} while (nama.length() < 3);
			
			do {
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				jenisKelamin = sc.nextLine();
			} while (!jenisKelamin.equals("Laki-laki") && !jenisKelamin.equals("Perempuan"));
			
			do {
				System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				jabatan = sc.nextLine();
			} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
			
			Random rand = new Random();
			ID = "" + (char)('A' + rand.nextInt(26)) + (char)('A' + rand.nextInt(26)) + "-" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + + rand.nextInt(10);
			
			System.out.println("Berhasil menambahkan karyawan dengan id " + ID);

			if (jabatanArr.get(number-1).equals("Manager")) {
				managerArr.remove(managerArr.size()-1);
				managerIDArr.remove(IDArr.get(number-1));
			}
			else if (jabatanArr.get(number-1).equals("Supervisor")) {
				supervisorArr.remove(supervisorArr.size()-1);
				supervisorIDArr.remove(IDArr.get(number-1));
			}
			else if (jabatanArr.get(number-1).equals("Admin")) {
				adminArr.remove(adminArr.size()-1);
				adminIDArr.remove(IDArr.get(number-1));
			}
			
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
				managerArr.add(jabatan);
				managerIDArr.add(ID);
			}
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
				supervisorArr.add(jabatan);
				supervisorIDArr.add(ID);
			}
			else if (jabatan.equals("Admin")) {
				gaji = 4000000;
				adminArr.add(jabatan);
				adminIDArr.add(ID);
			}
			
			namaArr.set((number-1), nama);
			jenisKelaminArr.set((number-1), jenisKelamin);
			jabatanArr.set((number-1), jabatan);
			IDArr.set((number-1), ID);
			gajiArr.set((number-1), gaji);
			
			if (managerArr.size() % 3 == 0 && managerArr.size() != 0) {
				for (int i = 0; i < managerIDArr.size(); i++) {
					gajiArr.set(i, (gajiArr.get(i) + (gaji * 10 / 100)));
				}
				System.out.println("Bonus sebesar 10% telah diberikan kepada karyawan dengan id " + (managerIDArr.toString().replace("[", "").replace("]", "")));
			}
			
			else if (supervisorArr.size() % 3 == 0 && supervisorArr.size() != 0) {
				for (int i = 0; i < supervisorArr.size(); i++) {
					gajiArr.set(i, (gajiArr.get(i) + (gaji * 7.5 / 100)));
				}
				System.out.println("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + (supervisorIDArr.toString().replace("[", "").replace("]", "")));
			}
			
			else if (adminArr.size() % 3 == 0 && adminArr.size() != 0) {
				for (int i = 0; i < adminArr.size(); i++) {
					gajiArr.set(i, (gajiArr.get(i) + (gaji * 5 / 100)));
				}
				System.out.println("Bonus sebesar 5% telah diberikan kepada karyawan dengan id " + (adminIDArr.toString().replace("[", "").replace("]", "")));
			}
			
			System.out.println("");
			menu();
		}
	}
	
	public void deleteKaryawan() {
		String tempNama = "", tempJenisKelamin = "", tempJabatan = "", tempID = "";
		int deleteNum = -1;
		double tempGaji = 0.0;
		
		if (namaArr.size() == 0) {
			System.out.println("No Karyawan found!");
			System.out.println("ENTER to return");
			sc.nextLine();
			menu();
		}
		else {
			for (int i = 0; i < namaArr.size() - 1; i++) {
				for (int j = i + 1; j < namaArr.size(); j++) {
					if (namaArr.get(i).compareToIgnoreCase(namaArr.get(j)) > 0) {
						tempNama = namaArr.get(i);
						namaArr.set(i, namaArr.get(j));
						namaArr.set(j, tempNama);

						tempJenisKelamin = jenisKelaminArr.get(i);
						jenisKelaminArr.set(i, jenisKelaminArr.get(j));
						jenisKelaminArr.set(j, tempJenisKelamin);

						tempJabatan = jabatanArr.get(i);
						jabatanArr.set(i, jabatanArr.get(j));
						jabatanArr.set(j, tempJabatan);
						
						tempID = IDArr.get(i);
						IDArr.set(i, IDArr.get(j));
						IDArr.set(j, tempID);
						
						tempGaji = gajiArr.get(i);
						gajiArr.set(i, gajiArr.get(j));
						gajiArr.set(j, tempGaji);

					}
				}
			}
			
			for (int i = 0; i < namaArr.size(); i++) {
				System.out.println("No." + (i+1));
				System.out.println("Kode Karyawan : " + IDArr.get(i));
				System.out.println("Nama Karyawan : " + namaArr.get(i));
				System.out.println("Jenis Kelamin : " + jenisKelaminArr.get(i));
				System.out.println("Jabatan       : " + jabatanArr.get(i));
				System.out.println("Gaji Karyawan : " + gajiArr.get(i));
				System.out.println("");
			}
		}
		
		do {
			try {
				System.out.print("Pilih nomor karyawan yang ingin dihapus [1..."+ namaArr.size() +"]: ");
				deleteNum = sc.nextInt();
			} catch (Exception e) {
				
			}sc.nextLine();
		} while (deleteNum < 1 || deleteNum > namaArr.size());
		
		namaArr.remove(deleteNum-1);
		jenisKelaminArr.remove(deleteNum-1);
		jabatanArr.remove(deleteNum-1);
		IDArr.remove(deleteNum-1);
		gajiArr.remove(deleteNum-1);
		
		System.out.println("");
		menu();
	}

}
