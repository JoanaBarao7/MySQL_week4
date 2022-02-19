package entity;

public class Cat {
	
	private int catId;
	private String catName;
	
	public Cat(int catId, String catName) {
		this.setCatId(catId);
		this.setCatName(catName);
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
		
}
