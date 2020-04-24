package com.capgemini.backgroundverification.entity;



	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.Lob;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;



	@Entity
	@Table(name="Filemodel")
	public class FileModel {
		@Id
		@GeneratedValue
	    @Column(name = "id")
	    private Long id;
		
	    @Column(name = "name")
		private String name;
	    
	    @Column(name = "mimetype")
		private String mimetype;
		
		@Lob
	    @Column(name="pic")
	    private byte[] pic;
		
		/*@OneToOne(cascade=CascadeType.ALL)   
		@JoinColumn(name="userId")
		private Logindata logindata;
		
		@OneToOne(cascade=CascadeType.ALL)   
		@JoinColumn(name="verId")
		private verification verification;*/
		
		@OneToOne(mappedBy="filemodel")
		private Verification verification;
		
		public FileModel()
		{
			
		}

		/*public verification getVerification() {
			return verification;
		}

		public void setVerification(verification verification) {
			this.verification = verification;
		}*/

		public FileModel(String name, String mimetype, byte[] pic){
			this.name = name;
			this.mimetype = mimetype;
			this.pic = pic;
		}
		
		public Long getId(){
			return this.id;
		}
		
		public void setId(Long id){
			this.id = id;
		}
		
		public String getName(){
			return this.name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String getMimetype(){
			return this.mimetype;
		}
		
		public void setMimetype(String mimetype){
			this.mimetype = mimetype;
		}
		
		public byte[] getPic(){
			return this.pic;
		}
		
		public void setPic(byte[] pic){
			this.pic = pic;
		}
	}

