package com.warren.bootstrap.knights;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/29 18:11
 * @since jdk11
 */
public class DamselRescuingKnight implements Knight {

	private RescueDamselQuest quest;

	public DamselRescuingKnight() {
		this.quest = new RescueDamselQuest();
	}

	@Override
	public void embarkOnQuest() {
			quest.embarkOnQuest();
	}
}
