package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Catalogue")
//@XmlType (propOrder = {"catalogueList", "idCounter"})
@XmlType (propOrder = {"catalogueList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalogue {
	
	@XmlElement(name = "CatalogueList")
	private List<Member> catalogueList = new ArrayList <Member> ();
	
	
	/*==== Constructor ====*/
	public Catalogue () {}
	
	public void addMember(Member aMember) {		
		
		catalogueList.add(aMember);
	}
	
	public void updateMember(Member oldMember, Member currentMember) {
		oldMember.Set(currentMember);
	}
	
	public Member getMember(int id) {
		for (Member member : catalogueList) {
			if(member.getMemberId() == id)
				return member;
		}
		return null;
	}
	
	public void deleteMember(Member aMember) {
		catalogueList.remove(aMember);
	}
	
	public Stream<Member> getCatalogue() {
		return catalogueList.stream();
	}
	
	public boolean isEmpty() {
		return catalogueList.isEmpty();
	}
}
