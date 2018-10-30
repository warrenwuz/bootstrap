package com.warren.bootstrap.knights;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/29 18:20
 * @since jdk11
 */
public class BraveKnight implements Knight {

	private Quest quest;

	public BraveKnight(Quest quest) {
		this.quest = quest;
	}
	@Override
	public void embarkOnQuest() {
		quest.embark();
	}
}
