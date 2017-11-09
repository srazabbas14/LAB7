package lab07.lab07;

public class set_item {
	private String item_name;
	private int price;
	private int time;
	
	public set_item()
	{
		item_name="";
		price=0;
		time=0;
	}
	
	public void setItem(String n) {
		item_name=n;
		
	}

	public void setPrice(int p) {
		price=p;
		
	}

	public void setTime(int t) {
		time=t;
		
	}

	public void setValues(String n, int p, int t)
	{
		setItem(n);
		setPrice(p);
		setTime(t);
	}
	
	public String getItem()
	{return item_name;}
	
	public int getPrice()
	{return price;}
	
	public int getTime()
	{return time;}
	
	
}

