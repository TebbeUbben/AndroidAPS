package info.nightscout.androidaps.plugins.PumpInsightLocal.app_layer.parameter_blocks;

import info.nightscout.androidaps.plugins.PumpInsightLocal.descriptors.BasalProfile;
import info.nightscout.androidaps.plugins.PumpInsightLocal.ids.ActiveBasalProfileIDs;
import info.nightscout.androidaps.plugins.PumpInsightLocal.utils.ByteBuf;

public class ActiveBRProfileBlock extends ParameterBlock {

    private BasalProfile activeBasalProfile;

    @Override
    public void parse(ByteBuf byteBuf) {
        activeBasalProfile = ActiveBasalProfileIDs.IDS.getType(byteBuf.readUInt16LE());
    }

    @Override
    public ByteBuf getData() {
        ByteBuf byteBuf = new ByteBuf(2);
        byteBuf.putUInt16LE(ActiveBasalProfileIDs.IDS.getID(activeBasalProfile));
        return byteBuf;
    }

    public BasalProfile getActiveBasalProfile() {
        return activeBasalProfile;
    }

    public void setActiveBasalProfile(BasalProfile activeBasalProfile) {
        this.activeBasalProfile = activeBasalProfile;
    }
}
