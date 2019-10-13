package unitofwork;

import java.util.ArrayList;

import datasource.CommentMapper;
import dto.Comment;;

public class CommentUnitOfWork {
	private ArrayList<Comment> newComments;
	private ArrayList<Comment> deleteComments;
	private CommentMapper commentMapper;
	
	public CommentUnitOfWork() {
		commentMapper = new CommentMapper();
	}
	
	public boolean addComment(Comment comment, boolean instantCommit) {
		if(newComments == null) {
			newComments = new ArrayList<>();
		}
		newComments.add(comment);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}
	
	public boolean deleteComment(Comment comment, boolean instantCommit) {
		if(deleteComments == null) {
			deleteComments = new ArrayList<>();
		}
		deleteComments.add(comment);
		
		if(instantCommit) {
			return doCommit()[1];
		}
		
		return true;
	}
	
    // get comment by a range, what is range can be found in comment mapper
	public ArrayList<Comment> getCommentsByRange(String range, String[] parameters) {
		ArrayList<Comment> thisRangeComments = commentMapper.getCommentsByRange(range, parameters);
		return thisRangeComments;
		
	}
	
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		boolean isDeleteSuccess = true;
		
		if(newComments != null) {
			if(newComments.size() > 0) {
				if(commentMapper.insert(newComments)){
					newComments.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		if(deleteComments != null) {
			if(deleteComments.size() > 0 ) {
				if(commentMapper.delete(deleteComments)) {
					deleteComments.clear();
				}
				else {
					isDeleteSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess, isDeleteSuccess};
	}
}
