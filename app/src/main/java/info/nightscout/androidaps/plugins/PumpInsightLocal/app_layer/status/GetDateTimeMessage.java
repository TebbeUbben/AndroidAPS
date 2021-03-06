package info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.status;

import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.AppLayerMessage;
import info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.Service;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.MessagePriority;
import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.PumpTime;
import info.nightscout.androidaps.plugins.PumpInsightLocal.utils.ByteBuf;

public class GetDateTimeMessage extends AppLayerMessage {

    private PumpTime pumpTime;

    public GetDateTimeMessage() {
        super(MessagePriority.NORMAL, true, false, Service.STATUS);
    }

    @Override
    protected void parse(ByteBuf byteBuf) {
        pumpTime = new PumpTime();
        pumpTime.setYear(byteBuf.readUInt16LE());
        pumpTime.setMonth(byteBuf.readUInt8());
        pumpTime.setDay(byteBuf.readUInt8());
        pumpTime.setHour(byteBuf.readUInt8());
        pumpTime.setMinute(byteBuf.readUInt8());
        pumpTime.setSecond(byteBuf.readUInt8());
    }

    public PumpTime getPumpTime() {
        return this.pumpTime;
    }
}
