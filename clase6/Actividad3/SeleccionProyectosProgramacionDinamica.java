package Actividad3;

public class SeleccionProyectosProgramacionDinamica 
{

    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) 
    {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j <= presupuesto; j++) 
            {
                if (costos[i - 1] <= j) 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                    
                else 
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][presupuesto];
    }

    public static void main(String[] args) 
    {
        int[] costos = {5, 3, 4};
        int[] beneficios = {60,50,70};
        int presupuesto = 8;

        int beneficiosMaximo = optimizarPresupuesto(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + beneficiosMaximo);
    }
}
