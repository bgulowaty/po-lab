package pwr.edu.notes;

public class NewNote {

  private final String title;
  private final String subtitle;
  private final String body;

  public NewNote(String title, String subtitle, String body) {
    this.title = title;
    this.subtitle = subtitle;
    this.body = body;
  }

  String getTitle() {
    return title;
  }

  String getSubtitle() {
    return subtitle;
  }

  String getBody() {
    return body;
  }
}
