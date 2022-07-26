package com.talosvfx.talos.editor.addons.scene.apps.tween.nodes;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.XmlReader;
import com.talosvfx.talos.editor.addons.scene.apps.tween.TweenStage;
import com.talosvfx.talos.editor.nodes.widgets.ButtonWidget;
import com.talosvfx.talos.editor.nodes.widgets.TextValueWidget;

public class TweenNode extends AbstractTweenNode {

    @Override
    protected void addAdditionalContent(Table contentTable) {

    }

    @Override
    protected void onSignalReceived(String command, Object[] payload) {
        if(command.equals("execute")) {
            playTween();
        }
    }

    private void playTween() {
        String target = (String) (getWidget("target").getValue());
        Object[] payload = new Object[1];
        payload[0] = target;
        sendSignal("startSignal", "execute", payload);
    }

    @Override
    public void constructNode(XmlReader.Element module) {
        super.constructNode(module);

        ButtonWidget playButton = getButton("playButton");

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playTween();
                super.clicked(event, x, y);
            }
        });

    }

    public String getTweenTitle() {
        TextValueWidget titleText = (TextValueWidget) getWidget("title");
        return titleText.getValue();
    }
}
