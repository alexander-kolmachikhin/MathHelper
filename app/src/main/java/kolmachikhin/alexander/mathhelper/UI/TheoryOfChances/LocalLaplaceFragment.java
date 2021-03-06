package kolmachikhin.alexander.mathhelper.UI.TheoryOfChances;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import kolmachikhin.alexander.mathhelper.Core.TheoryOfChancesLogic.LaplaceLogic;
import kolmachikhin.alexander.mathhelper.R;
import kolmachikhin.alexander.mathhelper.UI.CalcFragment;

public class LocalLaplaceFragment extends CalcFragment {

    private EditText etM;
    private EditText etN;
    private EditText etP;

    private int m, n;
    private double p;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.local_laplace_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        etM = v.findViewById(R.id.et_m);
        etN = v.findViewById(R.id.et_n);
        etP = v.findViewById(R.id.et_p);
    }

    @Override
    protected void getValues() {
        m = Integer.parseInt(etM.getText().toString());
        n = Integer.parseInt(etN.getText().toString());
        p = Double.parseDouble(etP.getText().toString());
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void calculate() {
        double l = LaplaceLogic.localLaplace(m, n, p);
        double u = (m - n * p) / Math.sqrt(n * p * (1-p));
        double fiu = LaplaceLogic.funLocalLaplace(m, n, p);

        setTvResult("Ответ = " +  String.format("%.10f", l)
                + "\nu = " + String.format("%.10f", u)
                + "\nfi(u) = " + String.format("%.10f", fiu));
    }

}
