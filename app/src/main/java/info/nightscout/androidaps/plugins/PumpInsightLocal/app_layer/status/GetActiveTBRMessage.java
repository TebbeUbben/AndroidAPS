package info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.status;

import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.AppLayerMessage;
import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.Service;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.ActiveTBR;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.MessagePriority;
import info.nightscout.androidaps.plugins.PumpInsightLocal.utils.ByteBuf;

public class GetActiveTBRMessage extends AppLayerMessage {

    private ActiveTBR activeTBR;

    public GetActiveTBRMessage() {
        super(MessagePriority.NORMAL, true, false, Service.STATUS);
    }

    @Override
    protected void parse(ByteBuf byteBuf) {
        ActiveTBR activeTBR = new ActiveTBR();
        activeTBR.setPercentage(byteBuf.readUInt16LE());
        activeTBR.setRemainingDuration(byteBuf.readUInt16LE());
        activeTBR.setInitialDuration(byteBuf.readUInt16LE());
        if (activeTBR.getPercentage() != 100) this.activeTBR = activeTBR;
    }

    public ActiveTBR getActiveTBR() {
        return this.activeTBR;
    }
}
