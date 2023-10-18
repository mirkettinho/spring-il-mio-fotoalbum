package org.java.app;

import org.java.app.db.pojo.Category;
import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.CategoryServ;
import org.java.app.db.serv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	@Autowired
	private PhotoServ photoServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/// CATEGORY
		
		Category category1 = new Category("Immagini della natura");
		Category category2 = new Category("Tempo Atmoserico");
		Category category3 = new Category("Veicolo");
		Category category4 = new Category("Fotografia");
		Category category5 = new Category("Art Wallpapers");
		Category category6 = new Category("Paesaggio Urbano");
		Category category7 = new Category("Esperienza");
		Category category8 = new Category("Esplorazione");
		Category category9 = new Category("Notte");
		Category category10 = new Category("All'aperto");
				
				
		categoryServ.save(category1);
		categoryServ.save(category2);
		categoryServ.save(category3);
		categoryServ.save(category4);
		categoryServ.save(category5);
		categoryServ.save(category6);
		categoryServ.save(category7);
		categoryServ.save(category8);
		categoryServ.save(category9);
		categoryServ.save(category10);
		
		/// PHOTO
		
		Photo photo1 = new Photo("Shibuya, Tokyo", "Japan", "https://images.unsplash.com/photo-1697441642191-9be6641590bd?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", true, category1, category2, category3);
		Photo photo2 = new Photo("Chris Yang", "Canon", "https://images.unsplash.com/photo-1696945147512-745188d0ef77?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1064", true, category4, category5);
		Photo photo3 = new Photo("Silas Schneider", "Berlin, Deutschland", "https://images.unsplash.com/photo-1696960594920-1ca9a1f250bc?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1286", false, category6, category7, category8, category9);
		Photo photo4 = new Photo("DM David", "Vietnam", "https://images.unsplash.com/photo-1697292309873-fd899b125d5b?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", true, category10);
		Photo photo5 = new Photo("NEOM", "Hisma Desert, Arabia", "https://images.unsplash.com/photo-1682686580922-2e594f8bdaa7?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", true, category9, category8, category7, category6, category5);
		Photo photo6 = new Photo("Zetong Li", "Nikon Z6", "https://images.unsplash.com/photo-1697438858951-b57b577db305?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1286", true, category4, category3);
		Photo photo7 = new Photo("Martin Marek", "Sony, ILCE-7M", "https://images.unsplash.com/photo-1697128439428-a68faa7f2537?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", true, category2);
		Photo photo8 = new Photo("Dylann Hendricks", "Canon, EOS 6D", "https://images.unsplash.com/photo-1697118728449-428a17808138?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1335", false, category1, category2, category3, category4);
		Photo photo9 = new Photo("Alesan Aboafash", "Canon, EOS 6D", "https://images.unsplash.com/photo-1696815115273-2c08b938b4b9?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", true, category5, category6);
		Photo photo10 = new Photo("Martin Marek", "Canon, EOS 6D", "https://images.unsplash.com/photo-1696789990524-e1282ade1bf0?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1287", false, category7);
		
		
		photoServ.save(photo1);
		photoServ.save(photo2);
		photoServ.save(photo3);
		photoServ.save(photo4);
		photoServ.save(photo5);
		photoServ.save(photo6);
		photoServ.save(photo7);
		photoServ.save(photo8);
		photoServ.save(photo9);
		photoServ.save(photo10);
		
		
		
	}

}
