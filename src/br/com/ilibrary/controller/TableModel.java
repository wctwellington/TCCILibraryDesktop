package br.com.ilibrary.controller;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
}
