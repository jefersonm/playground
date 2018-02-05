package com.ilegra.horas;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ilegra.horas.pojo.Atividade;

public class MenuAdapter extends ArrayAdapter<Atividade> {

	private List<Atividade> itens;

	public MenuAdapter(Context context, int textViewResourceId, List<Atividade> itens) {
		super(context, textViewResourceId, itens);
		this.itens = itens;
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View gridView = convertView;
		if (convertView == null) { // if it's not recycled, initialize some
			// attributes
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			gridView = inflater.inflate(R.layout.menu_detail, parent, false);
		}
		Atividade atividade = itens.get(position);
		((TextView) gridView.findViewById(R.id.menu_data)).setText(atividade.getData());
		((TextView) gridView.findViewById(R.id.menu_desc)).setText(atividade.getDesc());
		return gridView;
	}

}
