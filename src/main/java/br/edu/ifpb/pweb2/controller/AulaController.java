/*
 * package br.edu.ifpb.pweb2.controller;
 * 
 * import java.util.List;
 * 
 * import javax.faces.annotation.RequestMap; import javax.inject.Inject;
 * 
 * import br.edu.ifpb.pweb2.dao.AlunoDAO; import br.edu.ifpb.pweb2.dao.AulaDAO;
 * import br.edu.ifpb.pweb2.model.Aluno; import br.edu.ifpb.pweb2.model.Aula;
 * 
 * public class AulaController {
 * 
 * @Inject private AulaDAO aulaDAO;
 * 
 * @Inject private AlunoDAO alunoDAO;
 * 
 * @RequestMap("/registrar-presenca") public String registrarPresenca(Aula aula)
 * {
 * 
 * List<Aluno> alunos = aula.getPresenca(); aulaDAO.save(aula); aulaDAO.flush();
 * for (Aluno aluno : alunos) { aluno.addPresenca(aula); alunoDAO.save(aluno);
 * alunoDAO.flush(); } return "redirect:/turmas"; }
 * 
 * // public String registrar(Model model, String assunto, String date, String
 * turma) { // Aula aula = new Aula(); // aula.setAssunto(assunto); //
 * SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); // Date data =
 * null; // try { // data = new java.sql.Date(format.parse(date).getTime()); //
 * } catch (ParseException e) { // e.printStackTrace(); // } //
 * aula.setData(data); // Optional<Turma> opT =
 * turmaDAO.findTurmaByCodigo(Long.parseLong(turma)); // Turma t = null; // if
 * (opT.isPresent()) { // t = opT.get(); // } // aula.setTurma(t); //
 * t.addAulas(aula); // aulaDAO.save(aula); // turmaDAO.saveAndFlush(t); //
 * aulaDAO.flush(); // model.addAttribute("aula", aula); //
 * model.addAttribute("turma", t); // return "aula/registrar-presenca"; // } }
 */