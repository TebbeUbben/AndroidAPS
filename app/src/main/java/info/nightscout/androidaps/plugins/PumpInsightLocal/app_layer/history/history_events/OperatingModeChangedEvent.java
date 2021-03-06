package info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.history.history_events;

import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.OperatingMode;
import info.nightscout.androidaps.plugins.PumpInsightLocal.ids.OperatingModeIDs;
import info.nightscout.androidaps.plugins.PumpInsightLocal.utils.ByteBuf;

public class OperatingModeChangedEvent extends HistoryEvent {

    private OperatingMode oldValue;
    private OperatingMode newValue;

    @Override
    public void parse(ByteBuf byteBuf) {
        oldValue = OperatingModeIDs.IDS.getType(byteBuf.readUInt16LE());
        newValue = OperatingModeIDs.IDS.getType(byteBuf.readUInt16LE());
    }


    public OperatingMode getOldValue() {
        return oldValue;
    }

    public OperatingMode getNewValue() {
        return newValue;
    }
}
