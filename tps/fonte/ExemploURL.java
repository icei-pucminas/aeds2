import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class ExemploURL {
	public static String getHtml(String endereco){
		StringBuffer resp = new StringBuffer();
		try {
			URL obj = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Método de requisição
			con.setRequestMethod("GET");

			// Código de resposta da conexão
			int responseCode = con.getResponseCode();
			System.out.println("Código de resposta: " + responseCode);

			// Se a conexão foi bem-sucedida (código 200)
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					resp.append(inputLine);
				}

				// Fecha os buffers
				in.close();

			} else {
				System.out.println("Erro na conexão: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}      

		return resp.toString();
	}
	public static void main(String[] args) {
		String endereco, html;
		endereco = "http://verde.icei.pucminas.br/tp01/Friends.html";
		html = getHtml(endereco);
		System.out.print(html);
	}
}
