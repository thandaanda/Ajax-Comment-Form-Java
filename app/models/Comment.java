package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Comment extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String comment;

	public static final Finder<Long, Comment> find = new Finder<Long, Comment>(
			Long.class, Comment.class);

	public static Comment create(String comment2) {
		// TODO Auto-generated method stub
		final Comment comment = new Comment();
		comment.comment = comment2;
		comment.save();
		return comment;
		
	}

	
	
	
	
	
	
	
	
	

}
