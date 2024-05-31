package Entity;

public class book {
	
	int id;
	String BookName;
	String BookImage;
	String AuthorName;
	String PublicationName;
	String Description;
	
	String BookPrice;
	
	public book() {
		super();
	}

	public book(String bookName, String bookImage, String authorName, String publicationName, String description,
			String bookPrice) {
		super();
		BookName = bookName;
		BookImage = bookImage;
		AuthorName = authorName;
		PublicationName = publicationName;
		Description = description;
		BookPrice = bookPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookImage() {
		return BookImage;
	}

	public void setBookImage(String bookImage) {
		BookImage = bookImage;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getPublicationName() {
		return PublicationName;
	}

	public void setPublicationName(String publicationName) {
		PublicationName = publicationName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBookPrice() {
		return BookPrice;
	}

	public void setBookPrice(String bookPrice) {
		BookPrice = bookPrice;
	}
	
	


}
