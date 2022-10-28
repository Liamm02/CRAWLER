public class JsonBuilder {

    private String title;
    private String author;
    private String editor;
    private String releaseDate;
    private String language;
    private String producedBy;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("************************************");
        sb.append("\nTitle: ").append(title);
        sb.append("\nAuthor: ").append(author);
        sb.append("\nEditor: ").append(editor);
        sb.append("\nRelease Date: ").append(releaseDate);
        sb.append("\nLanguage: ").append(language);
        sb.append("\nProduced By: ").append(producedBy);
        sb.append("\n************************************");
        return sb.toString();
    }



}
