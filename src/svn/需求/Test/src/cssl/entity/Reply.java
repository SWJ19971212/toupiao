package cssl.entity;
import java.util.Date;
import lombok.Data;

@Data
public class Reply {

	private int rid;
	private int invid;
	private String content;
	private String author;
	private Data createdate;
	
	
}
