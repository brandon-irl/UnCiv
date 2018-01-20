package com.unciv.ui.pickerscreens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.unciv.ui.utils.CameraStageBaseScreen;

public class PickerScreen extends CameraStageBaseScreen {

    TextButton closeButton;
    protected Label descriptionLabel;
    protected TextButton rightSideButton;
    float screenSplit = 0.85f;
    protected Table topTable;
    SplitPane splitPane;


    public PickerScreen() {
        Table buttonTable = new Table();

        closeButton = new TextButton("Close", skin);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setWorldScreen();
                dispose();
            }
        });
        buttonTable.add(closeButton).width(stage.getWidth() / 4);

        descriptionLabel = new Label("", skin);
        descriptionLabel.setWrap(true);
        descriptionLabel.setFontScale(game.settings.labelScale);
        descriptionLabel.setWidth(stage.getWidth() / 2);
        buttonTable.add(descriptionLabel).pad(5).width(stage.getWidth() / 2);

        rightSideButton = new TextButton("", skin);
        buttonTable.add(rightSideButton).width(stage.getWidth() / 4);
        buttonTable.setHeight(stage.getHeight()*(1-screenSplit));
        buttonTable.align(Align.center);
        rightSideButton.setColor(Color.GRAY);
        rightSideButton.setTouchable(Touchable.disabled);

        topTable = new Table();
        ScrollPane scrollPane = new ScrollPane(topTable);

        scrollPane.setSize(stage.getWidth(), stage.getHeight() * screenSplit);

        splitPane = new SplitPane(scrollPane, buttonTable, true, skin);
        splitPane.setSplitAmount(screenSplit);
        splitPane.setFillParent(true);
        stage.addActor(splitPane);
    }

    protected void pick(String rightButtonText){
        rightSideButton.setTouchable(Touchable.enabled);
        rightSideButton.setColor(Color.WHITE);
        rightSideButton.setText(rightButtonText);
    }
}
