package vitor.test.quarkus.lambda;

public class BookCreateDTO {

    private String title;
    private String libraryCode;
    private String catalogingDate;

    public BookCreateDTO(){}

    public BookCreateDTO(String title, String libraryCode, String catalogingDate) {
        setTitle(title);
        this.libraryCode = libraryCode;
        this.catalogingDate = catalogingDate;
    }

    public void setTitle(String title) {
        if(title != null)
            title = title.trim();

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }

    public String getCatalogingDate() {
        return catalogingDate;
    }

    public void setCatalogingDate(String catalogingDate) {
        this.catalogingDate = catalogingDate;
    }

}
