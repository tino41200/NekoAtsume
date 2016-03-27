package com.sprsec.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="astuce")
public class Astuce implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_astuce", unique = true, nullable = false)
	private Integer idastuce;
	
	@Column(name = "chat_nom", length = 50)
	private String nomchat;
	@Column(name = "user_name", length = 50)
	private String username;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "vote_plus", length = 50)
	private String voteplus;
	@Column(name = "vote_moins")
	private Integer vote_moins;
	
	public Astuce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Astuce(String nomchat, String username, String commentaire, String voteplus, Integer vote_moins) {
		super();
		this.nomchat = nomchat;
		this.username = username;
		this.commentaire = commentaire;
		this.voteplus = voteplus;
		this.vote_moins = vote_moins;
	}

	public Integer getIdastuce() {
		return idastuce;
	}

	public void setIdastuce(Integer idastuce) {
		this.idastuce = idastuce;
	}

	public String getNomchat() {
		return nomchat;
	}

	public void setNomchat(String nomchat) {
		this.nomchat = nomchat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getVoteplus() {
		return voteplus;
	}

	public void setVoteplus(String voteplus) {
		this.voteplus = voteplus;
	}

	public Integer getVote_moins() {
		return vote_moins;
	}

	public void setVote_moins(Integer vote_moins) {
		this.vote_moins = vote_moins;
	}
	
	
	
	

}
