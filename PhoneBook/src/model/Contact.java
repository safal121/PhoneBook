package model;

public class Contact {

	private String _firstname;
	//private String _middlename;
	private String _lastname;
	private String _contactno;
	private String _email;
	private String _address;
	private String _userid;
	int _contactid;
	public Contact(){
		
	}
	public Contact(String _firstname,String _lastname,String _contactno,String _email,String _address,int _contactid){
		this._firstname=_firstname;
		this._lastname=_lastname;
		//this._middlename=_middlename;
		this._contactno=_contactno;
		this._address=_address;
		this._email=_email;
		this._contactid=_contactid;
	}
	
	public Contact(String _firstname,String _lastname,String _contactno,String _email,String _address,String _userid){
		this._firstname=_firstname;
		this._lastname=_lastname;
		//this._middlename=_middlename;
		this._contactno=_contactno;
		this._address=_address;
		this._email=_email;
		this._userid=_userid;
		
		
	}
	
	public Contact(String _firstname,String _lastname,String _contactno,String _email,String _address,String _userid,int _contactid){
		this._firstname=_firstname;
		this._lastname=_lastname;
		//this._middlename=_middlename;
		this._contactno=_contactno;
		this._address=_address;
		this._email=_email;
		this._userid=_userid;
		this._contactid=_contactid;
		
	}
	
	

	public String get_firstname() {
		return _firstname;
	}

//	public String get_middlename() {
//		return _middlename;
//	}

	public String get_lastname() {
		return _lastname;
	}

	public String get_contactno() {
		return _contactno;
	}

	public String get_email() {
		return _email;
	}

	public String get_address() {
		return _address;
	}
	
	public int get_contactid(){
		return _contactid;
	}
	
	public String get_userid(){
		return _userid;
	}
}
