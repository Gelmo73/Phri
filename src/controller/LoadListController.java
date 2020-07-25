package controller;

import java.util.List;
import components.PanelBlock;

public interface LoadListController<T> {
	
	public PanelBlock createPanelBlock(T obj);
	
	public List<PanelBlock> getList();

}
