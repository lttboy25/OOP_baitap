package ChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSCX {
	ArrayList <ChuyenXe> listChuyenXe;

	public DSCX() {
		listChuyenXe = new ArrayList<ChuyenXe>();
	}
	public void addTrip(ChuyenXe addChuyenXe) throws Exception{
		if (listChuyenXe.contains(addChuyenXe)==false) {
			listChuyenXe.add(addChuyenXe);
		}else {
			throw new Exception("Trùng mã chuyến xe");
		}
	}
	
	public void deleteTrip(ChuyenXe deleteChuyenXe) {
		listChuyenXe.remove(deleteChuyenXe);
	}
	
	public ChuyenXe search(String codeTrip) {
		for (ChuyenXe chuyenXe : listChuyenXe) {
			if (chuyenXe.getTripCode().equalsIgnoreCase(codeTrip)) {
				return chuyenXe;
			}
		}return null;
	}
	
	public int searchPosition(String codeTrip){
		return search(codeTrip) != null ? listChuyenXe.indexOf(search(codeTrip)) : -1;
	}
	
	public void modify(ChuyenXe modifyChuyenXe) {
		listChuyenXe.set(searchPosition(modifyChuyenXe.getTripCode()), modifyChuyenXe);
	}
	
	public double totalRevenue() {
		double total = 0.0;
		for (ChuyenXe chuyenXe : listChuyenXe) {
			total += chuyenXe.getRevenue();
		}return total;
	}
	
	public void sortByRevenue() {
	    Collections.sort(listChuyenXe, new Comparator<ChuyenXe>() {
	        @Override
	        public int compare(ChuyenXe chuyenXe1, ChuyenXe chuyenXe2) {
	            return Double.compare(chuyenXe2.getRevenue(), chuyenXe1.getRevenue());
	        }
	    });
	}
	
	public void sortByDriverName() {
	    Collections.sort(listChuyenXe, new Comparator<ChuyenXe>() {
	        @Override
	        public int compare(ChuyenXe chuyenXe1, ChuyenXe chuyenXe2) {
	            return chuyenXe1.getDriverName().substring(chuyenXe1.getDriverName().lastIndexOf(" ")+1).compareToIgnoreCase(chuyenXe2.getDriverName().substring(chuyenXe2.getDriverName().lastIndexOf(" ")+1));
	        }
	    });
	}

	public void sortByTwoFieds() {
	    Collections.sort(listChuyenXe, new Comparator<ChuyenXe>() {
	        @Override
	        public int compare(ChuyenXe chuyenXe1, ChuyenXe chuyenXe2) {
	            int comparisonResult = chuyenXe1.getDriverName().substring(chuyenXe1.getDriverName().lastIndexOf(" ")+1).compareToIgnoreCase(chuyenXe2.getDriverName().substring(chuyenXe2.getDriverName().lastIndexOf(" ")+1));
	            return (comparisonResult != 0) ? comparisonResult : Double.compare(chuyenXe2.getRevenue(), chuyenXe1.getRevenue());
	        }
	    });
	}
	
	public int countTrip() {
		return listChuyenXe.size();
	}
	
	public int countTripNT() {
		int countNT = 0;
		for (ChuyenXe chuyenXe : listChuyenXe) {
			if (chuyenXe instanceof NoiThanh) {
				countNT++;
			}
		}return countNT;
	}
	
	public int countTripNGT() {
		int countNGT = 0;
		for (ChuyenXe chuyenXe : listChuyenXe) {
			if (chuyenXe instanceof NgoaiThanh) {
				countNGT++;
			}
		}return countNGT;
	}

	public ArrayList <ChuyenXe> getListNgoaiThanh(){
		ArrayList <ChuyenXe> listNgoaiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe chuyenXe : listChuyenXe) {
			if (chuyenXe instanceof NgoaiThanh) {
				listNgoaiThanh.add(chuyenXe);
			}
		}return listNgoaiThanh;
	}
	public ArrayList <ChuyenXe> getListNoiThanh(){
		ArrayList <ChuyenXe> listNoiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe chuyenXe : listChuyenXe) {
			if (chuyenXe instanceof NoiThanh) {
				listNoiThanh.add(chuyenXe);
			}
		}return listNoiThanh;
	}
	
	public ArrayList<ChuyenXe> getList(){
		return listChuyenXe;
	}
}
