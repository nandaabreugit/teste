package adapter;

public class SensorLixeiraAdapter implements LeitorSensor {
    private SensorAntigo sensorAntigo;

    public SensorLixeiraAdapter(SensorAntigo sensorAntigo) {
        this.sensorAntigo = sensorAntigo;
    }

    @Override
    public double lerNivel() {
        String txt = sensorAntigo.getNivelTexto();
        return Double.parseDouble(txt.replace("%", ""));
    }
}
