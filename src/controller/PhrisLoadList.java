package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.*;

import components.PanelBlock;
import components.LabelIcon;
import resources.FontAwesome;
import model.Phris;
import model.PhriModel;

public class PhrisLoadList implements LoadListController<Phris> {

	@Override
	public List<PanelBlock> getList() {
		List<PanelBlock> list = new ArrayList<PanelBlock>();
		List<Phris> phriList = PhriModel.getList();
		phriList.forEach(phri -> list.add(createPanelBlock(phri)));
		
		return list;
	}

	@Override
	public PanelBlock createPanelBlock(Phris obj) {
		String user = obj.getUser().getFullname();
		String content = obj.getContent();
		PanelBlock pb = new PanelBlock(user, content);
		
		LabelIcon like = new LabelIcon(FontAwesome.HEART_ICON);
		LabelIcon comment = new LabelIcon(FontAwesome.PLUS_ICON);
		
		try {
			FontAwesome font = new FontAwesome(FontAwesome.RESOURCES_REGULAR, 14f);
			like.setFont(font.getFont());
			comment.setFont(font.getFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		pb.getButtonPanel().add(like);
		pb.getButtonPanel().add(comment);
		
		return pb;
	}

}
