<%!
  public class Message {
    private String title;
    private String content;
    private String author;

    public Message(String title, String content, String author) {
      this.title = title;
      this.content = content;
      this.author = author;
    }

    public String getTitle() {
      return title;
    }

    public String getContent() {
      return content;
    }

    public String getAuthor() {
      return author;
    }
  }
%>

<%
  Message[] messageList = new Message[] {
    new Message("Foo", "Blah, blah, blah.", "Tom"),
    new Message("Bar", "Blah, blah, blah, again.", "Jerry")
  };
  
  pageContext.setAttribute("messageList", messageList);
%>