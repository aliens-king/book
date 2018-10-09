package com.assignment.books.dto;

/**
 * @author SUDHANSHU
 *
 */
public class MailDTO {
	private String from;
    private String to;
    private String subject;
    private String content;

    public MailDTO() {
    }

    public MailDTO(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    /**
     * @return getFrom
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return getTo
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return getSubject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return getContent
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}