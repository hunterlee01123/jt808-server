package org.yzh.protocol.commons.transform;

import io.github.yezhihao.protostar.DataType;
import io.github.yezhihao.protostar.PrepareLoadStrategy;
import io.github.yezhihao.protostar.converter.MapConverter;
import io.netty.buffer.ByteBuf;
import org.yzh.protocol.commons.transform.attribute.*;

/**
 * 位置附加信息转换器
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class AttributeConverter extends MapConverter<Integer, Object> {

    @Override
    protected void addSchemas(PrepareLoadStrategy schemaRegistry) {
        schemaRegistry
                .addSchema(AttributeId.Mileage, DataType.DWORD)
                .addSchema(AttributeId.Gas, DataType.WORD)
                .addSchema(AttributeId.Speed, DataType.WORD)
                .addSchema(AttributeId.AlarmEventId, DataType.WORD)
                .addSchema(AttributeId.TirePressure, TirePressure.Schema.INSTANCE)
                .addSchema(AttributeId.CarriageTemperature, DataType.WORD)

                .addSchema(AttributeId.OverSpeedAlarm, OverSpeedAlarm.Schema.INSTANCE)
                .addSchema(AttributeId.InOutAreaAlarm, InOutAreaAlarm.Schema.INSTANCE)
                .addSchema(AttributeId.RouteDriveTimeAlarm, RouteDriveTimeAlarm.Schema.INSTANCE)

                .addSchema(AttributeId.Signal, DataType.DWORD)
                .addSchema(AttributeId.IoState, DataType.WORD)
                .addSchema(AttributeId.AnalogQuantity, DataType.DWORD)
                .addSchema(AttributeId.SignalStrength, DataType.BYTE)
                .addSchema(AttributeId.GnssCount, DataType.BYTE)

                .addSchema(AttributeId.AlarmADAS, AlarmADAS.class)
                .addSchema(AttributeId.AlarmBSD, AlarmBSD.class)
                .addSchema(AttributeId.AlarmDSM, AlarmDSM.class)
                .addSchema(AttributeId.AlarmTPMS, AlarmTPMS.class)
        ;
    }

    @Override
    protected Integer readKey(ByteBuf input) {
        return (int) input.readUnsignedByte();
    }

    @Override
    protected void writeKey(ByteBuf output, Integer key) {
        output.writeByte(key);
    }

    @Override
    protected int valueSize() {
        return 1;
    }
}